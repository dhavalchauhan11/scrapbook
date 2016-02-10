package chap1;

/**
 * Created by dhavalchauhan on 1/23/14.
 */
public class chap1_1 {
    public boolean checkUniqueness(String str){


        // check if string has all unique characters
        // 1> initialize boolean array - for ASCII - character ASCII value is limited to 256
        // 2> Iterate throguh characters by characters - for first occurrence of characters ASCII value - set array index value to true
        // 3> Compare extracted character against StringBuffered String

        boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
            }
        return true;


    }
}
