/**
 * Author: dchauhan
 * Date: 6/5/16.
 */
// https://karussell.wordpress.com/2011/04/14/longest-common-substring-algorithm-in-java/
public class LongestCommonSubString {
    public static void main(String[] args) {
        String s1 = "Please, peter go swimming!";
        String s2 = "I’m peter goliswi";

        System.out.println(longestCommonSub(s1,s2));

    }

    public static String longestCommonSub(String s1,String s2){

        StringBuilder sb = new StringBuilder();
        if(s1 == null || s1.length() ==0 || s2 == null || s2.length() == 0){
            return "";
        }

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[][] num = new int[s1.length()][s2.length()];
        int maxLen = 0;
        int lastSubsBegin = 0;

        for(int i = 0;i<s1.length();i++){
            for(int j = 0;j<s2.length();j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    if((i == 0) || (j == 0)){
                        num[i][j] = 1;
                    } else {
                        // goes diagonal...
                        num[i][j] = 1 + num[i-1][j-1];
                    }

                    if (num[i][j] > maxLen) {
                        maxLen = num[i][j];

                        // generate substring from str1 => i
                        int thisSubsBegin = i - num[i][j] + 1;
                        if (lastSubsBegin == thisSubsBegin) {
                            //if the current LCS is the same as the last time this block ran
                            sb.append(s1.charAt(i));
                        } else {
                            //this block resets the string builder if a different LCS is found
                            lastSubsBegin = thisSubsBegin;
                            sb = new StringBuilder();
                            sb.append(s1.substring(lastSubsBegin, i + 1));
                        }
                    }
                }
            }
        }
        return sb.toString();
    }
}
