package com.algo.dp;

/**
 * Child going up the stairs
 * can hop either 1 or 2 or 3 steps
 * count possible number of ways she can reach nth step
 */
public class ChildStepsCountWays {
    public static void main(String[] args) {
        System.out.println("Recursion: " + countWaysR(3));
    }

    /**
     * Recursion
     * O(3^n)
     * @param n
     * @return
     */
    public static int countWaysR(int n){
        if(n < 0){
            return 0;
        }
        else if (n == 0){
            return 1;
        } else {
            return countWaysR(n -1) + countWaysR(n - 2) + countWaysR(n - 3);
        }

    }
}
