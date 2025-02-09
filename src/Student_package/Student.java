package Student_package;

public class Student {
    private int id;
    private String name;
    private String studentClass;
    private boolean doBorrowBook = false;

    public Student() {
    }

    public Student(int id, String name, String studentClass) {
        this.id = id;
        this.name = name;
        this.studentClass = studentClass;
    }

    public Student(int id, String name, String studentClass,boolean doBorrowBook) {
        this.id = id;
        this.name = name;
        this.studentClass = studentClass;
        this.doBorrowBook = doBorrowBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public boolean isDoBorrowBook() {
        return doBorrowBook;
    }

    public void setDoBorrowBook() {
        this.doBorrowBook = !this.doBorrowBook;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + studentClass + "," + doBorrowBook;
    }
}
