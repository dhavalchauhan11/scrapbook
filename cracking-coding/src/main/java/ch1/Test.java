package ch1;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: dchauhan
 * Date: 4/10/19.
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        String[] input = new String[]{"flower","flow","flight"};
        System.out.println(test.longestCommonPrefix(input));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
            int temp = strs[i].indexOf(prefix);

                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        return prefix;
    }
}
