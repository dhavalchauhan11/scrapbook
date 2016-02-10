package com.my.array;

import java.util.Scanner;

/**
 * Created by dhavalchauhan on 8/30/15.
 */
public class CountArray {
    public static void main(String[] args) {
        int size;
        int[] elements;
        int total = 0;

        Scanner in = new Scanner(System.in);

        // Read first line
        size = in.nextInt();

        // declare input elements array
        elements = new int[size];

        for(int i = 0;i<size;i++){
            elements[i] = in.nextInt();
            total += elements[i];
        }

        System.out.println(total);



    }
}
