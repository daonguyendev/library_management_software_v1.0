package Book_package;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BookManagementMenu {
    BookManagement bookManagement = BookManagement.getBookManagement();

    public void displayMenu() {
        System.out.println("==============================");
        System.out.println("|| === Book Management ===  ||");
        System.out.println("|| 1: Add book              ||");
        System.out.println("|| 2: Remove book           ||");
        System.out.println("|| 3: Search by ISBN        ||");
        System.out.println("|| 4: Search by Title       ||");
        System.out.println("|| 5: Display all           ||");
        System.out.println("|| 6: Update information    ||");
        System.out.println("|| 0: Exit program          ||");
        System.out.println("==============================");
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
                    case 2 -> remove();
                    case 3 -> searchByISBN();
                    case 4 -> searchByTitle();
                    case 5 -> displayAll();
                    case 6 -> updateInfo();
                    case 0 -> saveToFile();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong Format");
        }
    }

    public void add() {
        Book newBook = new Book(addISBN(), addTitle(), addAuthor(), addYear());
        bookManagement.add(newBook);
    }

    public String addISBN() {
        Scanner scanner = new Scanner(System.in);
        String isbn;
        while (true) {
            try {
                System.out.println("Enter ISBN");
                isbn = scanner.nextLine();
                if (isbn.equals("")) {
                    throw new NumberFormatException();
                }
                return isbn;
            } catch (NumberFormatException e) {
                System.out.println("ISBN Is Empty");
            }
        }
    }

    public String addTitle() {
        Scanner scanner = new Scanner(System.in);
        String title;
        while (true) {
            try {
                System.out.println("Enter title");
                title = scanner.nextLine();
                if (title.equals("")) {
                    throw new NumberFormatException();
                }
                return title;
            } catch (NumberFormatException e) {
                System.out.println("Title Is Empty");
            }
        }
    }

    public String addAuthor() {
        Scanner scanner = new Scanner(System.in);
        String author;
        while (true) {
            try {
                System.out.println("Enter author");
                author = scanner.nextLine();
                if (author.equals("")) {
                    throw new NumberFormatException();
                }
                return author;
            } catch (NumberFormatException e) {
                System.out.println("Author Is Empty");
            }
        }
    }

    public int addYear() {
        int year;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter year");
                year = scanner.nextInt();

                if (year < 1900 || year > 2022) {
                    throw new NumberFormatException();
                }
                return year;
            } catch (NumberFormatException e) {
                System.out.println("Year not valid");
            } catch (InputMismatchException e) {
                System.out.println("Year Wrong Format");

            }
        }
    }

    public void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ISBN");
        String isbn = scanner.nextLine();
        if (bookManagement.remove(isbn)) {
            System.out.println("Remove successful");
        } else {
            System.out.println("Remove fail!! Check ISBN");
        }
    }

    public void searchByISBN() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ISBN");
        String isbn = scanner.nextLine();
        Book searchBook = bookManagement.searchByISBN(isbn);
        if (searchBook != null) {
            System.out.println(searchBook);
        } else {
            System.out.println("Not found");
        }
    }

    public void searchByTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter title");
        String title = scanner.nextLine();
        List<Book> bookList = bookManagement.searchByTitle(title);
        for (Book b : bookList) {
            System.out.println(b);
        }
    }

    public void saveToFile() {
        bookManagement.saveToFile();
    }

    public void displayAll() {
        System.out.println(bookManagement.display());
    }

    public void updateInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ISBN");
        String isbn = scanner.nextLine();
        Book updateBook = bookManagement.searchByISBN(isbn);
        updateBook.setTitle(addTitle());
        updateBook.setAuthor(addAuthor());
        updateBook.setYear(addYear());
    }
}
