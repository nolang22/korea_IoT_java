package org.example.yello;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int v = sc.nextInt();
        int total = 0;

        for (int arrlist : arr) {
            if (arrlist == v) {
                total++;

            }
        }
        System.out.println(total);

    }

}