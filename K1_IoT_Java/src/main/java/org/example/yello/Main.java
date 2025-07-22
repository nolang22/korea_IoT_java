package org.example.yello;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 입출력기 생성
        Scanner sc = new Scanner(System.in);

        int max = sc.nextInt(); // 영수증에 적힌 총 금액
        int n = sc.nextInt(); // 물건 종류의 수
        int myMax = 0; // 물건 종류의 총 금액

        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt(); // 물건의 가격
            int b = sc.nextInt(); // 물건의 수량
            int sum = a * b; // sum = 가격 * 수량
            myMax += sum; // myMax = myMax + sum
        }

//        if (max == myMax) {
//            System.out.println("Yes");
//        } else {
//            System.out.println("No");
//        }
//                |  //삼항 연산자로 클린코드
//                V
        String yn = (max == myMax) ? "Yes" : "No"; // 참이면 "Yes", 거짓이라면 "No"
        System.out.println(yn);
    }
}