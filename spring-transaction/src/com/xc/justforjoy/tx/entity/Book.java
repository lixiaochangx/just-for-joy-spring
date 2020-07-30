package com.xc.justforjoy.tx.entity;

/**
 * @author lxcecho
 * @since 2020/7/30
 */
public class Book {

    private Integer id;

    private String isbn;

    private String bookName;

    private Double price;

    public Book() {
    }

    public Book(Integer id, String isbn, String bookName, Double price) {
        this.id = id;
        this.isbn = isbn;
        this.bookName = bookName;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                '}';
    }
}
