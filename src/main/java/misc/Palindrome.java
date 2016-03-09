package misc;

/**
 * Author: dchauhan
 * Date: 3/4/16.
 */
public class Palindrome {
    public static void main(String[] args) {
        String input = "abbaxyzpqqpzyxad";
        System.out.println(findLongestPeli(input));
    }

    public static String findLongestPeli(String input){
        String longest = input.substring(0,1);
        for(int i = 0;i < input.length()-1;i++){
            for(int j = i+1; j < input.length();j++){
                String temp = input.substring(i,j);
                if(isPalindrome(temp)){
                    if(temp.length() > longest.length()){
                        longest = temp;
                    }
                }
            }
        }
        return longest;
    }

    public static boolean isPalindrome(String input){
        int beg = 0;
        int end = input.length()-1;
        while(end > beg){
            if(input.charAt(beg) != input.charAt(end)){
                return false;
            }
            ++beg;
            --end;
        }
        return true;
    }
}
