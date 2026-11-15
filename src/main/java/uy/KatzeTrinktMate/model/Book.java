package uy.KatzeTrinktMate.model;

import java.math.BigDecimal;
import java.util.Objects;

import uy.KatzeTrinktMate.repository.BookActions;
import uy.KatzeTrinktMate.service.ValidationBook;

public class Book implements BookActions {
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private int year;
    private int stock;
    private BigDecimal price;

    //Constructor
    public Book(Long id, String isbn, String title, String author, int year, int stock, BigDecimal price) {
        setId(id);
        setIsbn(isbn);
        setTitle(title);
        setAuthor(author);
        setYear(year);
        setStock(stock);
        setPrice(price);
    }

    //Methods
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }

    //I choice isbn because each book has its own isbn. If i want to add or search an existing book, the equals method uses the isbn as unique identifier
    @Override
    public boolean equals(Object o){
        if (o == null || getClass() != o.getClass()) return false;
        Book libro = (Book) o;
        return Objects.equals(isbn, libro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }


    //getter and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    //Interfaces
    @Override
    public void addBook() {

    }

    @Override
    public void editBook() {

    }

    @Override
    public void showBooks() {

    }

    @Override
    public void bookForAuthor(String author) {

    }

    @Override
    public void bookForISBN(String isbn) {

    }

    @Override
    public void bookForTitle(String title) {

    }

    @Override
    public void deleteBook(Long id) {

    }
}
