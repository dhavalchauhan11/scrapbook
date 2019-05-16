package ch1;

/**
 * Author: dchauhan
 * Date: 4/21/19.
 */
public class StringCompress {

    public static void main(String[] args) {
        String test = "aaabbccccdd";
        StringCompress sc = new StringCompress();
        System.out.println(sc.doBadCompress(test));
        System.out.println(sc.doCompress(test));
    }

    public String doBadCompress(String input) {
        int countConsecutive = 0;
        String compressed = "";
        for(int i = 0 ; i<input.length() ; i++){
            countConsecutive++;
            if(i+1 >= input.length() || input.charAt(i) != input.charAt(i+1)){
                compressed += "" + input.charAt(i) + countConsecutive;
                countConsecutive=0;
            }
        }
        return compressed;
    }

    public String doCompress(String input) {
        StringBuilder compressed = new StringBuilder();
        int count = 0;


        for(int i = 0; i<input.length(); i++){
            count++;
            if(i+1 >= input.length() || input.charAt(i) != input.charAt(i+1)){
                compressed.append(input.charAt(i));
                compressed.append(count);
                count=0;
            }
        }

        return compressed.toString();
    }
}
