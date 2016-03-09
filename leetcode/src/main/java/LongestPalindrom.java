/**
 * Author: dchauhan
 * Date: 2/17/16.
 */
public class LongestPalindrom {

    public static void main(String[] args) {
        LongestPalindrom lp = new LongestPalindrom();
        String s = "abaccddccefe";
//        String s = "HYTBCABADEFGHABCDEDCBAGHTFYW1234567887654321ZWETYGDE";
        System.out.println(lp.longestPalindromeSimple(s));
    }

    /**
     * *************************************************************************
     * Brut force - checks each substring to find out if it's palindrome or not
     * O(n3)
     * @param s
     * @return
     */
    public String longestPali(String s){
        String longestPeli = s.substring(0,1);
        for(int i=0;i<s.length()-1;i++){
            for(int j=i+1;j<s.length();j++){
                String temp = s.substring(i,j);
                if(isPalindrom(temp)){
                    if(temp.length() > longestPeli.length()){
                        longestPeli = temp;
                    }
                }
            }
        }
        return longestPeli;
    }

    public boolean isPalindrom(String input){
        int beg=0;
        int end=input.length()-1;
        while(end > beg){
            if(input.charAt(beg) != input.charAt(end)){
                return false;
            }
            ++beg;
            --end;
        }
        return true;
    }

    // * *************************************************************


    /**
     * * *************************************************************
     * Different approach - starts from Center
     * Complextiy - O(n2)
     * @param s
     * @return
     */
    public String longestPalindromeSimple(String s){
        int n = s.length();
        if(n == 0) return "";
        String longest = s.substring(0,1);  // single char is palindrome
        for(int i=0;i<n-1;i++){
            String p1 = expandAroundCenter(s,i,i);
            if(p1.length() > longest.length()){
                longest = p1;
            }

            String p2 = expandAroundCenter(s,i, i+1);
            if(p2.length() > longest.length()){
                longest = p2;
            }
        }

        return longest;
    }

    private String expandAroundCenter(String s, int c1, int c2) {
        int l = c1, r = c2;
        int n = s.length();
        while(l >=0 && r<= n-1 && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1,r);
    }

    // * *************************************************************
}
