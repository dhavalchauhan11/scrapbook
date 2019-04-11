package ch11_sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author: dchauhan
 * Date: 7/30/16.
 */
public class AnagramComparator implements Comparator<String> {

    public static String sortChars(String s){
        char[] contents = s.toCharArray();
        Arrays.sort(contents);
        return new String(contents);
    }

    public int compare(String o1, String o2) {
        return 0;
    }
}
