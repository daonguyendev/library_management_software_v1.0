package entity;

public class Book {
    private String ISBN;
    private String title;
    private String author;
    private int year;
    private boolean isStock = true;

    //private int amount;

    public Book() {
    }

    public boolean isStock() {
        return isStock;
    }

    public void setStock() {
        isStock = !isStock;
    }

    public Book(String ISBN, String title, String author, int year) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Book(String ISBN, String title, String author, int year,boolean isStock) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isStock = isStock;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return ISBN + "," + title + "," + author + "," + year + "," + isStock;
    }
}
