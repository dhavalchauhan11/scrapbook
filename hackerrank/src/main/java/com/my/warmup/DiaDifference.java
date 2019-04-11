package com.my.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Author: dchauhan
 * Date: 7/10/17.
 */
public class DiaDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        final int[][] matrix = new int[N][N];

        for(int x = 0; x < N; x++){
            String[] row = br.readLine().split(" ");
            for(int y = 0 ; y < N; y++){
                matrix[x][y] = Integer.parseInt(row[y]);
            }
        }

        long diff = 0;

        for(int x = 0, y = N; x < N ; ++x){
            int a = matrix[x][x];
            int b = matrix[x][--y];
            diff += a - b;
        }

        diff = (diff < 0) ? -diff : diff;

        System.out.println(diff);


//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        //Get size of matrix
//        final int N = Integer.parseInt(br.readLine());
//
//        //Get matrix
//        final int[][] matrix = new int[N][N];
//        for(int y = 0; y < N; ++y){
//            String[] row = br.readLine().split(" ");
//            for(int x = 0; x < N; ++x){
//                matrix[y][x] = Integer.parseInt(row[x]);
//            }
//        }
//
//        //Initialize difference
//        long diff = 0;
//
//        //Get difference of sum of diagonals
//        for(int y = 0, x = N; y < N; ++y){
//            diff += matrix[y][y] - matrix[y][--x];
//        }
//
//        //Convert to absolute difference
//        diff = (diff < 0) ? -diff : diff;
//
//        //Print absolute difference
//        System.out.print(diff);

    }
}
