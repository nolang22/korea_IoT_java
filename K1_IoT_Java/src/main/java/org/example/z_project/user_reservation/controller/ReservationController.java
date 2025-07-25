package org.example.z_project.user_reservation.controller;

import org.example.z_project.user_reservation.dto.ReservationResponseDto;
import org.example.z_project.user_reservation.dto.UserLoginRequestDto;
import org.example.z_project.user_reservation.dto.UserRegisterRequestDto;
import org.example.z_project.user_reservation.service.ReservationService;
import org.example.z_project.user_reservation.service.UserService;
import org.example.z_project.user_reservation.service.implement.ReservationServiceImpl;
import org.example.z_project.user_reservation.service.implement.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public class ReservationController {
    private final UserService userService;
    private final ReservationService reservationService;

    public ReservationController() {
        this.userService = new UserServiceImpl();
        this.reservationService = new ReservationServiceImpl(userService);
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = getChoice(sc);

            if (!processChoice(choice, sc)) {
                break; // processChoice의 반환이 false인 경우 무한 루프 종료 (7 >> false)
            }
        }
    }

    private void displayMenu() {
        System.out.println("1. 사용자 등록 | 2. 로그인 | 3. 로그아웃");
        System.out.println("4. 예약 등록 | 5. 예약 확인 | 6. 예약 취소");
        System.out.println("7. 종료 ");
        System.out.print("선택 >> ");
    }

    private int getChoice(Scanner sc) {
        while (!sc.hasNextInt()) {
            // hasNextInt()
            // : 입력값이 int면 true, 그렇지 않으면 false 반환

            // 입력값이  정수가 아닌 경우
            System.out.println("숫자를 입력해주세요.");
            sc.next();
        }
        return sc.nextInt();
    }

    private boolean processChoice(int choice, Scanner sc) {
        sc.nextLine();  // 정수값 입력받고 남은 버퍼 처리

        switch (choice) {
            case 1 -> {
                userService.registerUser(
                        new UserRegisterRequestDto(
                                input(sc, "사용자 ID"),
                                input(sc, "사용자 비밀번호"),
                                input(sc, "사용자 비밀번호 확인"),
                                input(sc, "사용자 이름"),
                                input(sc, "사용자 이메일")
                        )
                );
                System.out.println();
            }
            case 2 -> {
                userService.login(
                        new UserLoginRequestDto(
                                input(sc, "사용자 ID"),
                                input(sc, "사용자 비밀번호")
                        )
                );
                System.out.println();
            }
            case 3 -> {
                userService.logout();
                System.out.println();
            }
            case 4 -> {
                reservationService.createReservation(input(sc, "사용자 ID"));
                System.out.println();
            }
            case 5 -> {
                List<ReservationResponseDto> results = reservationService.getReservationByUserId(
                        input(sc,"사용자 ID")
                );
                results.forEach(System.out::println);
                System.out.println();
            }
            case 6 -> {
                String reservationId = input(sc, "예약 ID");

                try {
                    Long id = Long.parseLong(reservationId);
                    reservationService.cacelReservation(id);

                } catch (NumberFormatException e) {
                    System.out.println("예약 ID는 숫자여야합니다. 다시 시도해주세요.");
                }
                System.out.println();
            }
            case 7 -> {
                System.out.println("종료합니다.");
                return false;
            }


            default ->
                    System.out.println("숫자를 입력해주세요.");
        }
        return true;
    }

    private String input(Scanner sc, String prompt) {
        System.out.println(prompt + ": ");
        return sc.nextLine();
    }

}

