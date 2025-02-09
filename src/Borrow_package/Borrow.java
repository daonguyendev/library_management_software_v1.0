package Borrow_package;

import java.time.LocalDate;

public class Borrow {
    private static int count = 0;
    private int orderID;
    private int studentID;
    private String bookISBN;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Borrow() {
    }

    public Borrow(int studentID, String bookISBN, LocalDate borrowDate) {
        count++;
        this.orderID = count;
        this.studentID = studentID;
        this.bookISBN = bookISBN;
        this.borrowDate = borrowDate;
    }

    public Borrow(int id, int studentID, String bookISBN, LocalDate borrowDate, LocalDate returnDate) {
        this.orderID = id;
        this.studentID = studentID;
        this.bookISBN = bookISBN;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public static void setCount(int max) {
        Borrow.count = max;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return orderID + "," + studentID + "," + bookISBN + "," + borrowDate + "," + returnDate;
    }
}
