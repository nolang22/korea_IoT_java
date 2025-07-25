package org.example.z_project.__hamburger.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class Order {

    private Long orderNumber; // 예약 고유 번호
    private String nickname; // 해당 기록의 주문자 고유 닉네임
    private String orderBurger; // 주문한 음식
    private Date orderTime; // 주문 시간


}