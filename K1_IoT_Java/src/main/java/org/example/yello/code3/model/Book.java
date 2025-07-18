package org.example.yello.code3.model;


import org.example.yello.code3.util.DateUtil;

public class Book {
    String id;
    String title;
    String author;
    String createdAt;
    String updatedAt;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.createdAt = DateUtil.now();
        this.updatedAt = DateUtil.now();
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor(String author) { return author; }
    public String getCreatedAt() { return createdAt; }
    public String getUpdatedAt() { return updatedAt; }

    public void setAuthor(String author) {
        this.author = author;
        this.updatedAt = DateUtil.now();
    }


    @Override
    public String toString() {
        return "ID: " + id +
                ", Title: " + title +
                ", Author: " + author +
                ", CreatedAt " + createdAt +
                ", UpdatedAt: " + updatedAt;
    }

}
