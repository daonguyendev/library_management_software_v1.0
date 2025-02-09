package Book_package;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookManagement {
    private List<Book> books;
    private final String filePath = "books.csv";

    private static BookManagement bookManagement = new BookManagement();

    public static BookManagement getBookManagement() {
        return bookManagement;
    }

    private BookManagement() {
        this.books = new ArrayList<>();
        readFromFile();
    }

    public void add(Book b) {
        this.books.add(b);
    }

    public boolean remove(String isbn) {
        Book bookSearch = searchByISBN(isbn);
        if (bookSearch != null) {
            this.books.remove(bookSearch);
            return true;
        }
        return false;
    }

    public Book searchByISBN(String isbn) {
        for (Book b : this.books) {
            if (b.getISBN().equals(isbn)) {
                return b;
            }
        }
        return null;
    }

    public List<Book> searchByTitle(String title) {
        List<Book> bookList = new ArrayList<>();
        for (Book b : this.books) {
            if (b.getTitle().contains(title)) {
                bookList.add(b);
            }
        }
        return bookList;
    }

    public void saveToFile() {
        try {
            FileWriter fw = new FileWriter(filePath);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Book b : this.books) {
                bw.write(b.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("File Not Found");
        }
    }

    public void readFromFile() {
        try {
            this.books.clear();
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            Book b;
            while ((line = br.readLine()) != null) {
                b = handleLine(line);
                this.books.add(b);
            }
        } catch (IOException e) {
            System.out.println("File Not Found");
        }
    }

    public Book handleLine(String line) {
        String[] str = line.split(",");
        return new Book(str[0], str[1], str[2], Integer.parseInt(str[3]), Boolean.parseBoolean(str[4]));
    }

    public String display() {
        String listBook = "";
        for (Book b : this.books) {
            listBook += b.toString() + "\n";
        }
        return listBook;
    }
}
