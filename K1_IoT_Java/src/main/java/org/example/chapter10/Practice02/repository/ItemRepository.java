package org.example.chapter10.Practice02.repository;

import org.example.chapter10.Practice02.entity.Book;

import java.util.Set;

// DB를 대신하는 자바 내부의 저장소
// - ItemRepository: DB와 어떠한 행위를 할 것인지 약속 (interface)
// - InMemoryItemRepository: 데이터 처리에 대한 실질적인 행위 구현 (class)
public interface ItemRepository {
    void addItem(Book item);
    Set<Book> findAll();
    Book findById(String itemId);
    void removeItem(String itemId);
}
