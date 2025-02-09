package Student_package;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentManagementMenu {
    StudentManagement studentManagement = StudentManagement.getStudentManagement();

    public void displayMenu() {
        System.out.println("================================");
        System.out.println("|| === Student Management === ||");
        System.out.println("|| 1: Add student             ||");
        System.out.println("|| 2: Remove student          ||");
        System.out.println("|| 3: Search by ID            ||");
        System.out.println("|| 4: Search by Name          ||");
        System.out.println("|| 5: Display all             ||");
        System.out.println("|| 6: Update information      ||");
        System.out.println("|| 0: Exit program            ||");
        System.out.println("================================");
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
                    case 3 -> searchByID();
                    case 4 -> searchByName();
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
        Student newStudent = new Student(addId(), addName(), addClass());
        studentManagement.add(newStudent);
    }

    public int addId() {
        int id;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter ID");
                id = scanner.nextInt();
                if (id < 0) {
                    throw new NumberFormatException();
                }
                return id;
            } catch (NumberFormatException e) {
                System.out.println("ID not valid");
            } catch (InputMismatchException e) {
                System.out.println("ID Wrong Format");
            }
        }
    }

    public String addName() {
        Scanner scanner = new Scanner(System.in);
        String name;
        while (true) {
            try {
                System.out.println("Enter Name");
                name = scanner.nextLine();
                if (name.equals("")) {
                    throw new NumberFormatException();
                }
                return name;
            } catch (NumberFormatException e) {
                System.out.println("Name Is Empty");
            }
        }
    }

    public String addClass() {
        Scanner scanner = new Scanner(System.in);
        String studentClass;
        while (true) {
            try {
                System.out.println("Enter Student's Class");
                studentClass = scanner.nextLine();
                if (studentClass.equals("")) {
                    throw new NumberFormatException();
                }
                return studentClass;
            } catch (NumberFormatException e) {
                System.out.println("Student's Class Is Empty");
            }
        }
    }

    public void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID");
        int id = scanner.nextInt();
        if (studentManagement.remove(id)) {
            System.out.println("Remove successful");
        } else {
            System.out.println("Remove fail!! Check ID");
        }
    }

    public void searchByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID");
        int id = scanner.nextInt();
        Student searchStudent = studentManagement.searchByID(id);
        if (searchStudent != null) {
            System.out.println(searchStudent);
        } else {
            System.out.println("Not found");
        }
    }

    public void searchByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        List<Student> studentList = studentManagement.searchByName(name);
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public void displayAll() {
        System.out.println(studentManagement.display());
    }

    public void updateInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID");
        int id = scanner.nextInt();
        Student updateStudent = studentManagement.searchByID(id);
        updateStudent.setName(addName());
        updateStudent.setStudentClass(addClass());
    }

    public void saveToFile(){
        studentManagement.saveToFile();
    }
}
