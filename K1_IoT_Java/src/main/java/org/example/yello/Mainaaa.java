package org.example.yello;

import java.util.Scanner;

public class Mainaaa {
    public static void main(String[] args) {

        // 스캐너 입력기 생성
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();  // 몇번 반복할지 정하는 변수
        int c = 0;

        while (c<t) {  // 반복횟수가 정해진 경우 for문
            int a = scn.nextInt();  //
            int b = scn.nextInt();  // 숫자를 입력할 변수 2개
            int max = a + b;  // 숫자 두개를 더 해서 저장할 변수
            System.out.println(max);  // max값 출력
            c++;
        }
    }
}

