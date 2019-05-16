package com.my.warmup;

import java.util.Scanner;

/**
 * Author: dchauhan
 * Date: 3/8/16.
 */
public class DrawStaircase {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int height = sc.nextInt();
        draw(height);
    }

    public static void draw(int height){
        int count = 1;
        if(height > 0){
            for(int i = 1;i<=height;i++){
                for(int j=0;j<height;j++){
                    if((i+j) < height){
                        System.out.print(" ");
                    } else {
                        System.out.print("#");
                    }
                }
                System.out.println();
            }
        }
    }
}
