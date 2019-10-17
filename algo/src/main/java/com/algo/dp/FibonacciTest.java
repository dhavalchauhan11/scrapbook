package com.algo.dp;

public class FibonacciTest {

    /**
     * Compute N th fibonacci number
     * @param args
     */
    public static void main(String[] args) {
        // 0,1,1,2,3,5,8

        System.out.println(fiboRecursion(5));
        System.out.println(fiboMemoTopDown(5));
        System.out.println(fiboMemoBottomUp(5));
        System.out.println(fiboSimple(5));

    }

    /**
     * Recursion approach
     * @param n
     * @return
     */
    public static int fiboRecursion(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;

        return fiboRecursion(n - 1) + fiboRecursion(n - 2);
    }

    /**
     * Memoization - TOP-DOWN approach
     * i.e. build cache from given number
     * @param n
     * @return
     */
    public static int fiboMemoTopDown(int n) {
        return fiboMemoTopDown(n, new int[n+1]);
    }

    private static int fiboMemoTopDown(int i, int[] memo) {
        if(i == 0)
            return 0;

        if(i ==1)
            return 1;

        // if cache doesn't have entry for given input then
            // add one by recursively calling the method
        if(memo[i] == 0){
            memo[i] = fiboMemoTopDown(i - 1,memo) + fiboMemoTopDown(i - 2,memo);
        }

        return memo[i];
    }

    /**
     * Top-Down approach
     *  start adding values in memo cache until reached given number
     *  i.e. for number 5 - memo array will have 1,1,2,3,5
     *
     * return value by the original fibo equation
     * i.e n-1 + n-2
     *
     * @param n
     * @return
     */
    public static int fiboMemoBottomUp(int n){
        if(n == 0)
            return 0;
        else if (n == 1)
            return 1;

        int[] memo = new int[n];

        // start building memo cache proactively
        memo[0] = 0;
        memo[1] = 1;

        for(int i = 2;i<n;i++){
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n - 1] + memo[n - 2];

    }

    /**
     * **
     * @param n
     * @return
     */
    public static int fiboSimple(int n) {
        if(n == 0)
            return 0;

        int a = 0;
        int b = 1;

        for(int i = 2; i<n; i++){
            int c = a + b;
            a = b;
            b = c;
        }
         return a+b;
    }
}
