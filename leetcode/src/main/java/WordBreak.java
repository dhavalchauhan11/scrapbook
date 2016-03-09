import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Author: dchauhan
 * Date: 2/29/16.
 */
public class WordBreak {

    public static Set<String> dict;

    static{
        dict = new HashSet<String>();
        dict.add("mark");
        dict.add("monitor");
        dict.add("abc");
        dict.add("pqr");
        dict.add("ggh");
    }

    public static void main(String[] args) {
//        String input = "markmonitor";
        String input = "markmonitorabcpqrgghmark";

//        String output = segmentWordFizzBuzz(input,dict);
        String output = segmentWordRec(input,dict);
//        String output = segmentWordMemo(input,dict);
        System.out.println(output);
    }

    /**
     * Works only for two words and exact match
     * @param input
     * @param dict
     * @return
     */
    private static String segmentWordFizzBuzz(String input, Set<String> dict) {

       if(dict.contains(input))
           return input;

       int length = input.length();
        for(int i = 1;i<length;i++){
            String prefix = input.substring(0,i);
            if(dict.contains(prefix)){
                String suffix = input.substring(i,length);
                if(dict.contains(suffix)){
                    return prefix + " " + suffix;
                }
            }
        }

        return null;
    }

    private static String segmentWordRec(String input,Set<String> dict){
        if(dict.contains(input)){
            return input;
        }

        int length = input.length();
        for(int i=1;i<length;i++){
            String prefix = input.substring(0,i);
            if(dict.contains(prefix)){
                String suffix = input.substring(i,length);
                String suffixSeg = segmentWordRec(suffix,dict);
                if(suffixSeg!=null){
                    return  prefix + " " + suffixSeg;
                }
            }
        }

        return null;
    }

    private static Map<String, String> memoized = new HashMap<String, String>();
    private static String segmentWordMemo(String input,Set<String> dict){
        if(dict.contains(input))
            return input;

        if(memoized.containsKey(input)){
            return memoized.get(input);
        }

        int length = input.length();
        for(int i = 1;i<length;i++){
            String prefix = input.substring(0,i);
            if(dict.contains(prefix)){
                String suffix = input.substring(i,length);
                String segSuffix = segmentWordMemo(suffix,dict);
                if(segSuffix != null){
                    memoized.put(input, prefix + " " +segSuffix);
                    return prefix + " " + segSuffix;
                }
            }
        }
        memoized.put(input, null);
        return null;
    }

}
