package Borrow_package;

import Book_package.Book;
import Book_package.BookManagement;
import Student_package.Student;
import Student_package.StudentManagement;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class BorrowManagement {
    private final int timeBorrow = 7;

    private final String filePath = "borrow.csv";
    private List<Borrow> borrows;
    private BookManagement bookManagement = BookManagement.getBookManagement();
    private StudentManagement studentManagement = StudentManagement.getStudentManagement();

    private static BorrowManagement borrowManagement = new BorrowManagement();

    public static BorrowManagement getBorrowManagement() {
        return borrowManagement;
    }

    private BorrowManagement() {
        this.borrows = new ArrayList<>();
        readFromFile();
    }

    public void changeStatusStockOfBook(Borrow borrow) {
        Book borrowedBook = bookManagement.searchByISBN(borrow.getBookISBN());
        borrowedBook.setStock();
    }

    public void changeStatusBorrowOfStudent(Borrow borrow) {
        Student borrowStudent = studentManagement.searchByID(borrow.getStudentID());
        borrowStudent.setDoBorrowBook();
    }


    public void add(Borrow borrow) {
        this.borrows.add(borrow);
        changeStatusStockOfBook(borrow);
        changeStatusBorrowOfStudent(borrow);
    }

    public boolean updateReturnDate(int id) {
        Borrow searchBorrow = searchByOrderID(id);
        if (searchBorrow != null && searchBorrow.getReturnDate() == null) {
            searchBorrow.setReturnDate(LocalDate.now());
            changeStatusStockOfBook(searchBorrow);
            changeStatusBorrowOfStudent(searchBorrow);
            return true;
        }
        return false;
    }

    public Borrow searchByOrderID(int id) {
        for (Borrow b : this.borrows) {
            if (b.getOrderID() == id) {
                return b;
            }
        }
        return null;
    }

    public String displayBooks() {
        return bookManagement.display();
    }

    public String displayStudents() {
        return studentManagement.display();
    }

    public String displayAllBorrows() {
        String listBorrows = "";
        for (Borrow borrow : this.borrows) {
            listBorrows += borrow.toString() + "\n";
        }
        return listBorrows;
    }

    public List<Borrow> displayOverDate() {
        List<Borrow> overDateBorrow = new ArrayList<>();
        LocalDate dateBorrow;
        LocalDate today;
        for (Borrow borrow : this.borrows) {
            if (borrow.getReturnDate() == null) {
                today = LocalDate.now();
            } else {
                today = borrow.getReturnDate();
            }
            dateBorrow = today.minus(timeBorrow, ChronoUnit.DAYS);
            if (borrow.getBorrowDate().compareTo(dateBorrow) < 0) {
                overDateBorrow.add(borrow);
            }
        }
        return overDateBorrow;
    }

    public String displayMostBorrowedBooks() {
        Map<String, Integer> countBorrow = new HashMap<>();
        for (Borrow borrow : borrows) {
            String isbn = borrow.getBookISBN();
            if (countBorrow.containsKey(isbn)) {
                countBorrow.put(borrow.getBookISBN(), countBorrow.get(borrow.getBookISBN()) + 1);
            } else {
                countBorrow.put(borrow.getBookISBN(), 1);
            }
        }
        int max = Collections.max(countBorrow.values());
        String str = "ISBN -- Title --  Author --  Year -- Is Stock\n";
        for (Map.Entry<String, Integer> maps : countBorrow.entrySet()) {
            if (maps.getValue() == max) {
                str += bookManagement.searchByISBN(maps.getKey()) + "\n";
            }
        }
        str += "Borrowed Times: " + max + " times\n";
        return str;
    }

    public void readFromFile() {
        try {
            this.borrows.clear();
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            Borrow borrow;
            while ((line = br.readLine()) != null) {
                borrow = handleLine(line);
                this.borrows.add(borrow);
            }
            findMaxAndSetCount();
        } catch (IOException e) {
            System.out.println("File Not Found");
        }
    }

    public Borrow handleLine(String line) {
        String[] str = line.split(",");
        LocalDate returnDate = null;
        if (!str[4].equals("null")) {
            returnDate = LocalDate.parse(str[4]);
        }
        return new Borrow(Integer.parseInt(str[0]), Integer.parseInt(str[1]), str[2], LocalDate.parse(str[3]), returnDate);
    }

    public void saveToFile() {
        try {
            FileWriter fw = new FileWriter(filePath); //thêm true thi` se ko ghi đè lên dữ liệu cũ
            BufferedWriter bw = new BufferedWriter(fw);
            for (Borrow borrow : this.borrows) {
                bw.write(borrow.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
            bookManagement.saveToFile();
            studentManagement.saveToFile();
        } catch (IOException e) {
            System.out.println("File Not Found");
        }
    }

    public boolean checkStudentID(int id) {
        Student student = studentManagement.searchByID(id);
        return student != null && !student.isDoBorrowBook();
    }

    public boolean checkBookISBN(String isbn) {
        Book book = bookManagement.searchByISBN(isbn);
        return book != null && book.isStock();
    }

    public void findMaxAndSetCount() {
        int max = 0;
        for (Borrow borrow : this.borrows) {
            if (borrow.getOrderID() > max) {
                max = borrow.getOrderID();
            }
        }
        Borrow.setCount(max);
    }
}
