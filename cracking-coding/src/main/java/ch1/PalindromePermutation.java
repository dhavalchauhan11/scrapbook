package ch1;

/**
 * Author: dchauhan
 * Date: 4/8/19.
 */
public class PalindromePermutation {
    public static void main(String[] args) {
        PalindromePermutation permutation = new PalindromePermutation();
        System.out.println(permutation.isPerm("tact coa"));

    }

    public boolean isPerm(String phrase){
        if(phrase == null)
            return false;

        int[] count = new int[26];
        int oddCounts = 0;
        for(char c : phrase.toCharArray()){
            if(c >= 'a' && c <= 'z'){
                count[c - 'a']++;

                if(count[c - 'a'] %2 == 1){
                    oddCounts++;
                } else {
                    oddCounts--;
                }
            }
        }
        return oddCounts < 2;
    }

}
