/**
 * Author: dchauhan
 * Date: 2/17/16.
 */
public class Palindrom {
    public static void main(String[] args) {
        Palindrom p = new Palindrom();
        String test = "abba";
//        System.out.printf("isPali = " + p.isPalindrom(test.toCharArray()));
        System.out.printf("isPali = " + p.isPali(test));

    }

    public boolean isPalindrom(char[] word){
        int beg=0;
        int end=word.length-1;
        while(end > beg){
            if(word[beg] != word[end]){
                return false;
            }
            ++beg;
            --end;
        }
        return true;
    }

    public boolean isPali(String s){
        if(s.length() ==0 && s.length() ==1)
            return true;

        if(s.charAt(0) == s.charAt(s.length()-1)){
            return isPali(s.substring(1,s.length()-1));
        }

        return false;
    }
}
