package org.example.yello;

import java.util.Scanner;

public class Code01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        try {


            int num = a / b;
            System.out.println(a / b );
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
        }
        sc.close();
    }
}


