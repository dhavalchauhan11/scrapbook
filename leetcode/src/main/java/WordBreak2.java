import java.util.HashSet;
import java.util.Set;

/**
 * Author: dchauhan
 * Date: 3/2/16.
 */
public class WordBreak2 {
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
        String input = "markmonitor";

        String seg = segment(input,dict);
        System.out.println(seg);
    }

    public static String segment(String input,Set dict){
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<input.length();i++){
            for(int j=i+1;j<input.length();j++){
                String seg = input.substring(i,j);
                if(dict.contains(seg)){
                    sb.append(seg);
                }
            }
        }
        return sb.toString();
    }
}
