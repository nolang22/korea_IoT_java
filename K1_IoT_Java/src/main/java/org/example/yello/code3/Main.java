package org.example.yello.code3;

import org.example.yello.code3.exception.BookNotFoundException;
import org.example.yello.code3.model.Book;
import org.example.yello.code3.service.BookServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookServiceImpl bookService = new BookServiceImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=== Book Store ===");
            System.out.println("1. 도서 등록");
            System.out.println("2. 도서 전체 조회");
            System.out.println("3. 도서 ID로 조회");
            System.out.println("4. 도서 저자 수정");
            System.out.println("5. 책 삭재");
            System.out.println("6. 도서 제목으로 검색");
            System.out.println("7. 프로그램 종료");
            try {

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("ID: ");
                        String id =sc.nextLine();
                        System.out.print("책 제목: ");
                        String title = sc.nextLine();
                        System.out.print("책 저자: ");
                        String author = sc.nextLine();
                        bookService.addBook(new Book(id, title, author));

                        break;
                    case 2:
                        bookService.getReadAllBook();
                        break;
                    case 3:
                        System.out.print("도서 ID를 입력해주세요: ");
                        String readId = sc.nextLine();
                        bookService.getBookById(readId);

                        break;
                    case 4:
                        System.out.print("ID를 입력해주세요: ");
                        String updateId = sc.nextLine();
                        System.out.print("저자명을 알려주세요: ");
                        String newAuthor = sc.nextLine();

                        bookService.updateUser(updateId, newAuthor);
                        break;
                    case 5:
                        System.out.print("ID를 입력해주세요: ");
                        String removeId = sc.nextLine();

                        bookService.removeUser(removeId);
                        break;
                    case 6:
                        System.out.print("저자명을 알려주세요: ");
                        String readAuthor = sc.nextLine();
                        bookService.getTitleByTitle(readAuthor);
                        break;

                    case 7:
                        System.out.println("종료 합니다.");
                        sc.close();
                        return;

                    default:
                        System.out.println("유효하지 않은 숫자입니다. 다시 시도해주세요 :)");

                }
            } catch (BookNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }finally {
                System.out.println();
            }

        }


    }
}