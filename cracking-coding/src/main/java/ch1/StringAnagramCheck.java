package ch1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dhavalchauhan on 8/18/15.
 */
public class StringAnagramCheck {
    public static void main(String[] args) {

        Map<String,String> sampleData = new HashMap<String, String>(){{
            put("Mother-in-law","Woman Hitler1");
            put("The earthquakes","That queer shake");
        }};

        String a = "The earthquakes";
        String b = "That queer shake";
//        System.out.println(isAnagram(a,b));
//        System.out.println(isAnagramSorted(a,b));
        System.out.println(isAnagramUsingMap(a,b));
    }

    private static boolean isAnagram(String a, String b) {
        if(a.length() != b.length())
            return false;
        int[] letters = new int[256];
        int numUniqueChars = 0;
        int numCompleted = 0;

        // compute unique characters for String a
        char[] aChars = a.toCharArray();
        for(char c:aChars){
            if(letters[c]==0){
                ++numUniqueChars;
            }
            ++letters[c];
        }

        // Iterate through String b's characters and check against letters array
        for(int i = 0;i<b.length();++i){
            int c = b.charAt(i);
            if(letters[c] == 0){
                return false;
            }
            --letters[c];
            if (letters[c] == 0) {
                ++numCompleted;
                if(numCompleted == numUniqueChars){
                    return i == b.length() -1;
                }
            }
        }
        return false;
    }

    public static boolean isAnagramSorted(String a, String b){

        if(a.length() != b.length()){
            return false;
        }

        a = a.toLowerCase();
        b = b.toLowerCase();

        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);
        String sc1 = new String(c1);
        String sc2 = new String(c2);

        return sc1.equals(sc2);
    }

    /**
     * 1. Generate count of characters in first string
     * 2. Start decrementing the counter for each character in the second string
     * 3. The final Map should have zero count for each character
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean isAnagramUsingMap(String a, String b){

        Map<Character,Integer> s1Map = new HashMap<Character,Integer>();
        // Generate count for each character in string
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if(s1Map.containsKey(c)){
                int cnt = s1Map.get(c);
                s1Map.put(c,++cnt);
            } else {
                s1Map.put(c,1);
            }

        }

        // Start decrementing the count for the characters in second string
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            if(s1Map.containsKey(c)){
                int cnt = s1Map.get(c);
                s1Map.put(c,--cnt);
            }

        }

        for(Character c:s1Map.keySet()){
            if(s1Map.get(c) > 0){
                return false;
            }
        }

        return true;
    }
}
