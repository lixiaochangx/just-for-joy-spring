package com.xc.justforjoy.tx.entity;

/**
 * @author lxcecho
 * @since 2020/7/30
 */
public class BookStock {

    private Integer id;

    private String isbn;

    private Integer stock;

    public BookStock() {
    }

    public BookStock(Integer id, String isbn, Integer stock) {
        this.id = id;
        this.isbn = isbn;
        this.stock = stock;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "BookStock{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", stock=" + stock +
                '}';
    }
}
