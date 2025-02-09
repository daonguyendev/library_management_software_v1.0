import Book_package.BookManagementMenu;
import Borrow_package.BorrowManagementMenu;
import Student_package.StudentManagementMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookManagementMenu bookManagementMenu = new BookManagementMenu();
        StudentManagementMenu studentManagementMenu = new StudentManagementMenu();
        BorrowManagementMenu borrowManagementMenu = new BorrowManagementMenu();
        int choice = -1;
        while (choice != 0) {
            System.out.println("================================");
            System.out.println("||==== Library Management ====||");
            System.out.println("|| 1: Book Management         ||");
            System.out.println("|| 2: Student Management      ||");
            System.out.println("|| 3: Borrow Management       ||");
            System.out.println("|| 0: Exit program            ||");
            System.out.println("================================");
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter choice");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        bookManagementMenu.handleMenu();
                        break;
                    case 2:
                        studentManagementMenu.handleMenu();
                        break;
                    case 3:
                        borrowManagementMenu.handleMenu();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong Format");
            }
        }
    }
}