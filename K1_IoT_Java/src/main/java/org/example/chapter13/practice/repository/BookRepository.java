package org.example.chapter13.practice.repository;

import org.example.chapter13.practice.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 도서를 저장, 검색 및 삭제하는 데이터 저장소
public class BookRepository {
    // 단일 저장소를 위한 싱글톤(singleton) 인스턴스
    private static final BookRepository instance = new BookRepository();

    private BookRepository() {} // private 생성자 - 외부 호출 불가!

    //인스턴스 반환 메서드
    public static BookRepository getInstance() {
        return instance;
    }

    private List<Book> books = new ArrayList<>(); // DB(데이터베이스) 역할

    // 도서 저장소 (id 값을 Key로 저장 Map)
    private Map<String, Book> bookStore = new HashMap<>(); // DB(데이터베이스) 역할

    // 도서 저장(Create)
    public Book save(Book book) {
        // 중복된 id값 일 경우 도서 저장 X
        if (bookStore.containsKey(book.getId())) {
            // Map.containsKey(Key 타입 데이터): 포함 여부를 boolean 값으로 반환
            System.out.println("[" + book.getId() + "]의 책이 이미 존재합니다. 다시 입력해주세요.");
            return null;
        }
        bookStore.put(book.getId(), book);
        return book;

    }
    // 도서 조회(Read = 단건)
    public Book findById(String id) {
        return bookStore.get(id);

        /*  책 저장소 List 사용 시

            책 저장소 전체를 순회하여 매개변수의 id 값과 일치하는 요소를 필터링
         */
    }

    // 도서 조회(Read = 전체)
    public List<Book> findAll() {
        return new ArrayList<>(bookStore.values()); // Map의 값은 Book 타입
    }

    // 도서 삭제
    public boolean delete(String id) {
        if (!bookStore.containsKey(id)) {
            // 삭제하고자 하는 id의 책이 없은 경우
            System.out.println("[" + id + "]의 책이 존재하지 않습니다. 책이 삭제되지 않았습니다.");
            return false;
        }
        bookStore.remove(id);
        return true;
    }


}
