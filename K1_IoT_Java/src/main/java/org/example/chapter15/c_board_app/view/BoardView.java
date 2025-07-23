package org.example.chapter15.c_board_app.view;

import org.example.chapter15.c_board_app.controller.BoardController;
import org.example.chapter15.c_board_app.dto.BoardRequestDto;
import org.example.chapter15.c_board_app.dto.BoardResponseDto;

import java.util.List;
import java.util.Scanner;

/*  === 게시글 관리 시스템 ===

    Board 게시판
    : CRUD
 */
public class BoardView {
    public static void main(String[] args) {
        BoardController boardController = new BoardController();

        Scanner sc = new Scanner(System.in);

        while (true) {
            // View(프론트엔드)
            // Controller(사용자의 입력과 선택을 받아 제어하는 역할 - 백엔드)
            try {
                System.out.println("\n[ 게시판 관리 시스템 ]");
                System.out.println("1. 게시글 등록");
                System.out.println("2. 게시글 전체 조회(게시글 목록)");
                System.out.println("3. 게시글 단건 조회(게시글 상세 페이지");
                System.out.println("4. 게시글 수정");
                System.out.println("5. 게시글 삭제");
                System.out.println("0. 프로그램 종료");

                System.out.print("메뉴를 선책해 주세요 >> ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> {
                        System.out.println("게시글 등록(제목, 내용, 작성자를 입력해주세요.");
                        System.out.print("제목: ");
                        String title = sc.nextLine();
                        System.out.print("내용: ");
                        String content = sc.nextLine();
                        System.out.print("작성자: ");
                        String author = sc.nextLine();

                        boardController.createBoard(new BoardRequestDto(title, content, author));
                        System.out.println();
                    }
                    case 2 -> {
                        System.out.println("게시글 전체 조회");
                        List<BoardResponseDto> dtos = boardController.getAllBoards();
                        dtos.forEach(System.out::println);
                    }
                    case 3 -> {
                        System.out.println("게시글 단건 조회");
                        System.out.print("조회할 게시글 ID: ");
                        Long id = sc.nextLong();
                        sc.nextLine();

                        BoardResponseDto dto = boardController.getBoardById(id);
                        System.out.println(dto);
                    }
                    case 4 -> {
                        System.out.println("수정할 게시글의 id와 새로운 제목과 내용을 입력해주세요.");
                        System.out.print("수정할 게시글 ID: ");
                        Long updatedId = sc.nextLong();
                        sc.nextLine();

                        System.out.print("새 제목: ");
                        String title = sc.nextLine();
                        System.out.print("새 내용: ");
                        String content = sc.nextLine();

                        BoardRequestDto dto = new BoardRequestDto(title, content, "수정은 작성 X");
                        // BoardCreatRequestDto (title, content, author)
                        // BoardUpdateRequestDto (title, content)
                        boardController.updateBoard(updatedId,dto);

                    }
                    case 5 -> {
                        System.out.println("게시글 삭제");
                        System.out.print("삭제할 게시글 ID: ");
                        Long id = sc.nextLong();
                        sc.nextLine();

                        boardController.deleteBoard(id);
                    }
                    case 0 -> {
                        System.out.println("프로그램을 종료합니다.");
                        sc.close();
                        return; // 반복문(무한루프) 종료
                    }
                    default ->
                        System.out.println("숫자를 다시 입력해주세요. 0~5사이의 숫자를 입력해주세요");

                }
            } catch (IllegalArgumentException e) {
                //인수값으로 부적절한 값을 넘길 때 발생하는 예외
                System.out.println("ID값을 확인해주세요: " + e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
