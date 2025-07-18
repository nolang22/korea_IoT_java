package org.example.chapter10.Practice02.repository;

import org.example.chapter10.Practice02.entity.Book;

import java.util.HashSet;
import java.util.Set;

public class InMemoryItemRepository implements ItemRepository{
    private Set<Book> items = new HashSet<Book>();


    @Override
    public void addItem(Book item) {
        items.add(item);
    }

    @Override
    public Set<Book> findAll() {
        return new HashSet<>(items); // 방어적 복사 (주소값이 원본 데이터와 다름)
    }

    @Override
    public Book findById(String itemId) {
        for (Book item : items) {
            if (item.getId().equals(itemId)) {
                return item;
            }
        }

        return null; // 객체 타입(참조 타입)의 기본 형태 null
    }

    @Override
    public void removeItem(String itemId) {
       Book target = null;

        for (Book item: items) {
            if (item.getId().equals(itemId)) {
                target = item;
                break;
            }
        }
        if (target != null) {
            items.remove((target));
        }
    }
}

