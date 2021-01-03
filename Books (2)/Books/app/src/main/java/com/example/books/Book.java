package com.example.books;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private String genre;
    private double rate;
    private int img;
    private String isbn;
    private String series;
    private String des;

    public Book(String title, String author, String genre, double rate, int img, String isbn, String series, String des) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rate = rate;
        this.img = img;
        this.isbn = isbn;
        this.series = series;
        this.des = des;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        if (rate <= 5 && rate >= 0)
            this.rate = rate;
        else
            rate = 2.5; //for simplicity since it's not entered by user
    }


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
