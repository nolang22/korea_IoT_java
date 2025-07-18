package org.example.chapter10.Practice02.service;

import org.example.chapter10.Practice02.entity.Book;

import java.util.List;

public interface InventoryService {

    void addItem(Book item);

    List<Book> getItemsByCategory(String category);

    boolean updateItemPrice(String itemId, int newPrice);

    void deleteItem(String itemId);
}
