package org.example.yello.code3.service;


import org.example.yello.code3.exception.BookNotFoundException;
import org.example.yello.code3.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    List<Book> bookList = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        bookList.add(book);
    }

    @Override
    public void getBookById(String id) {

        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                System.out.println(book);
                return;
            }

        }

        throw new BookNotFoundException("검색한 ID: " + id + "가 없습니다. ");
    }

    @Override
    public void getReadAllBook() {
        List<Book> books = new ArrayList<>(bookList);
        if (bookList.isEmpty()) {
            System.out.println("책이 없습니다.");
        } else {
            System.out.println("전체 책 조회");
            for (Book book : bookList) {
                System.out.println(book);

            }
        }

    }

    @Override
    public void updateUser(String id, String author) {
        List<Book> books = new ArrayList<>(bookList);
        for (Book book : books) {
            if (book.getId().equals(id)) {
                book.setAuthor(author);
                System.out.println("변경 되었습니다");
                return;
            }
        }
        throw new BookNotFoundException("저자를 바꾸지 못했습니다");

    }

    @Override
    public void removeUser(String id) {
        Book remoneBook = null;
        List<Book> books = new ArrayList<>(bookList);
        for (Book book: books) {
            if (book.getId().equals(id)) {
                remoneBook = book;

            }
        }
        if (remoneBook != null) {
            bookList.remove((remoneBook));
            return;
        }

        throw new BookNotFoundException("삭제할 ID: " + id + "가 없습니다");

    }

    @Override
    public void  getTitleByTitle(String title) {

        for (Book book : bookList) {
            if (book.getTitle().contains(title)) {
                System.out.println(book);
                return;
            }
        }
        throw new BookNotFoundException("검색한 " + title + "의 책이 없습니다");
    }


}
