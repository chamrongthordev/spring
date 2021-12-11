package com.chamrong.mustache.model;

public class Book {
  private Long bookId;
  private String isbn;
  private String bookTitle;
  private String author;
  private Double price;

  public Book() {
  }

  public Book(Long bookId, String isbn, String bookTitle, String author, Double price) {
    this.bookId = bookId;
    this.isbn = isbn;
    this.bookTitle = bookTitle;
    this.author = author;
    this.price = price;
  }

  public Long getBookId() {
    return bookId;
  }

  public void setBookId(Long bookId) {
    this.bookId = bookId;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getBookTitle() {
    return bookTitle;
  }

  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
}
