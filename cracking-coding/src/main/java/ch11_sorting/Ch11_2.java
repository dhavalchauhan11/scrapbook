package ch11_sorting;

import java.util.*;

/**
 * Write method to sort an array of strings so that all the anagrams are next to each other
 */
public class Ch11_2 {
    public static void main(String[] args) {
        String[] arr = new String[]{"race","make","care","kame","arce"};

        sort(arr);

        System.out.println(Arrays.asList(arr));
    }

    public static String sortChars(String s){
        char[] contents = s.toCharArray();
        Arrays.sort(contents);
        return new String(contents);
    }

    /**
     * 1. Sort the characters in the String
     * 2. Group the strings together
     * 3. reconstruct the array by merging these groups
     * @param input
     */
    public static void sort(String[] input){
        Map<String,LinkedList<String>> map = new HashMap<String, LinkedList<String>>();

        // create the groups
        for(String s:input){
            // sort characters and generate possible key
            String key = sortChars(s);

            // If the map already has the key then simply append input string in the linkedlist
            if(map.containsKey(key)){
                LinkedList<String> temp = map.get(key);
                temp.add(s);
            } else {
                LinkedList<String> temp = new LinkedList<String>();
                temp.add(s);
                map.put(key,temp);
            }
        }

        Iterator<String> mapItr = map.keySet().iterator();

        int index = 0;
        // Iterate through the keys and append corresponding list to array
        for(String key:map.keySet()){
            LinkedList<String> list = map.get(key);
            for(String s:list){
                input[index] = s;
                index++;
            }
        }
    }
}
