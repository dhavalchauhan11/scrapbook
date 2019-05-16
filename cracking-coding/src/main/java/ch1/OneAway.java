package ch1;

/**
 * Author: dchauhan
 * Date: 4/10/19.
 */
public class OneAway {
    /**
     pale, ple -> true
     pales, pale -> true
     pale, bale -> true
     pale, bake -> false
     */
    public static void main(String[] args) {
        OneAway oa = new OneAway();
        System.out.println(oa.isOneEditAway("pale","pales"));

    }

    public boolean isOneEditAway(String s1, String s2) {
        if(s1 == null || s2 == null){
            return false;
        }
        // same length and single character difference
        if(s1.length() == s2.length()){
            return replace(s1,s2);
        } else if(s1.length() + 1 == s2.length()){
            return edit(s1,s2);
        } else if (s1.length() - 1 == s2.length()) {
            return edit(s2,s1);
        }

        return false;
    }

    public boolean replace(String s1, String s2) {
        boolean foundDiff = false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        for(int i = 0; i < c1.length; i++){
            if(c1[i] != c2[i]){
                if(foundDiff) {
                    return false;
                }
                foundDiff = true;
            }
        }
        return true;
    }

    public boolean edit(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        while(index1 < s1.length() && index2 < s2.length()){
            if(c1[index1] != c2[index2]){
                if(index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }
}
