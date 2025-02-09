package Borrow_package;

import java.time.LocalDate;
import java.util.*;

public class BorrowManagementMenu {
    BorrowManagement borrowManagement = BorrowManagement.getBorrowManagement();

    public void displayMenu() {
        System.out.println("=========================================");
        System.out.println("||    ===== Borrow Management =====    ||");
        System.out.println("|| 1:  Add new order                   ||");
        System.out.println("|| 2:  Update return date              ||");
        System.out.println("|| 3:  Search order by ID              ||");
        System.out.println("|| 4:  Display the most borrowed book  ||");
        System.out.println("|| 5:  Display books and students      ||");
        System.out.println("|| 6:  Display all orders              ||");
        System.out.println("|| 7:  Display order out of date       ||");
        System.out.println("|| 0: Exit program                     ||");
        System.out.println("=========================================");
    }

    public void handleMenu() {
        try {
            Scanner scanner = new Scanner(System.in);
            int choice = -1;
            while (choice != 0) {
                displayMenu();
                System.out.println("Enter choice");
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> add();
                    case 2 -> updateReturnDate();
                    case 3 -> searchByOrderID();
                    case 4 -> displayMostBorrowedBooks();
                    case 5 -> displayBoosAndStudents();
                    case 6 -> displayAll();
                    case 7 -> displayOverDate();
                    case 0 -> saveToFile();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong Format");
        }
    }

    public void add() {
        borrowManagement.add(new Borrow(addStudentID(), addBookISBN(), addBorrowDate()));
    }

    public int addStudentID() {
        int id;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter Student ID");
                id = scanner.nextInt();
                if (borrowManagement.checkStudentID(id)) {
                    return id;
                } else {
                    System.out.println("Not Found Student Or Student Can't Borrow Another Book");
                }
            } catch (InputMismatchException e) {
                System.out.println("ID Is Empty Or Wrong Format");
            }
        }
    }

    public String addBookISBN() {
        String isbn;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter book's ISBN");
                isbn = scanner.nextLine();
                if (borrowManagement.checkBookISBN(isbn)) {
                    return isbn;
                } else {
                    System.out.println("Not Found Book Or Book Out Of Stock");
                }
            } catch (InputMismatchException e) {
                System.out.println("ISBN Is Empty");
            }
        }
    }

    public LocalDate addBorrowDate() {
        return LocalDate.now();
    }

    public void updateReturnDate() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter order's ID");
            int id = scanner.nextInt();
            if (borrowManagement.updateReturnDate(id)) {
                System.out.printf("Order '%d' Finished\n", id);
            } else {
                System.out.println("Not Found Order Or Order Already Finished");
            }
        } catch (InputMismatchException e) {
            System.out.println("ID Is Empty Or Wrong Format");
        }
    }

    public void searchByOrderID() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter order's ID");
            int id = scanner.nextInt();
            Borrow searchBorrow = borrowManagement.searchByOrderID(id);
            if (searchBorrow != null) {
                System.out.println(searchBorrow);
            } else {
                System.out.println("Not Found Order");
            }
        } catch (InputMismatchException e) {
            System.out.println("ID Is Empty Or Wrong Format");
        }
    }

    public void displayMostBorrowedBooks() {
        System.out.println("Most Borrowed Book");
        if (borrowManagement.displayMostBorrowedBooks() != null) {
            System.out.println(borrowManagement.displayMostBorrowedBooks());
            System.out.println("Display Successfully");
        } else {
            System.out.println("No Book");
        }
    }

    public void displayAll() {
        System.out.println("All Of Order");
        if (borrowManagement.displayAllBorrows() != null) {
            System.out.println(borrowManagement.displayAllBorrows());
            System.out.println("Display Successfully");
        } else {
            System.out.println("No Order");
        }
    }

    public void displayOverDate() {
        System.out.println("List Order Out Of Date");
        if (borrowManagement.displayOverDate().size() != 0) {
            for (Borrow borrow : borrowManagement.displayOverDate()) {
                System.out.println(borrow);
            }
        } else {
            System.out.println("No Order");
        }
    }

    public void displayBoosAndStudents() {
        System.out.println("List of books: ");
        System.out.println(borrowManagement.displayBooks());
        System.out.println("List of students: ");
        System.out.println(borrowManagement.displayStudents());
    }

    public void saveToFile() {
        borrowManagement.saveToFile();
        System.out.println("Update To books.csv And students.csv successfully");
    }
}
