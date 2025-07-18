package org.example.chapter10.Practice02.service;

import org.example.chapter10.Practice02.entity.Book;
import org.example.chapter10.Practice02.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class InventoryServiceImpl implements InventoryService{
    private final ItemRepository repository;

    public InventoryServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addItem(Book item) {
        repository.addItem(item);

    }

    @Override
    public List<Book> getItemsByCategory(String category) {
        Set<Book> allItems = repository.findAll();
        List<Book> categoryItems = new ArrayList<Book>();

        for (Book item : allItems) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                categoryItems.add(item);
            }
        }
        return categoryItems;
    }

    @Override
    public boolean updateItemPrice(String itemId, int newPrice) {
        boolean isUpdated = false;
        // 수정할 Item이 저장소에 존재하는지 확인

        Book item = repository.findById(itemId);

        if (item != null) {
            item.setPrice(newPrice);
            isUpdated = true;
            return isUpdated;

        }
        System.out.println("바꿀수 없습니다.");
        return false;
    }

    @Override
    public void deleteItem(String itemId) {
        Book item = repository.findById(itemId);

        if (item != null) {
            repository.removeItem(itemId);

        }

    }
}
