package com.my.string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Author: dchauhan
 * Date: 3/5/16.
 */
public class Panagram {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input = sc.nextLine();
        if (isPanagram(input)){
            System.out.println("pangram");
        } else {
            System.out.println("not pangram");
        }
    }

//    "We promptly judged antique ivory buckles for the prize" - not pamgram
//    "We promptly judged antique ivory buckles for the next prize" - pangram


    public static boolean isPanagram(String input){
        Set<Character> lettersRemaining = new HashSet<Character>();

        for(char c='a';c<='z';c++){
            lettersRemaining.add(c);
        }

        input = input.toLowerCase();
        for(int i = 0;i<input.length();i++){
            lettersRemaining.remove(input.charAt(i));
        }

        return lettersRemaining.isEmpty();
    }
}
