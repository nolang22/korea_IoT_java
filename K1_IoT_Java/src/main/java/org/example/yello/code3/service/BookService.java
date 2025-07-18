package org.example.yello.code3.service;

import org.example.yello.code3.model.Book;

import java.util.List;

public interface BookService  {

    void addBook(Book book);

    void getBookById(String id);

    void getReadAllBook();

    void updateUser(String id, String author);

    void removeUser(String id);

    void getTitleByTitle(String title);


}
