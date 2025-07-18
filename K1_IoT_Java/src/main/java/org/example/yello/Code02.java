package org.example.yello;

import java.util.Scanner;

public class Code02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (i <n) {

                if (arr[i] < min) {
                    min = arr[i];
                }

            }

        }

        System.out.println(min);
        sc.close();
    }
}
