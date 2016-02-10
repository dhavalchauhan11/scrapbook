/**
 * Created by dhavalchauhan on 12/10/13.
 */
public class Utility {

    public static void main(String args[]){
        String test = "Reverse me";

        String link = "http://tech-trip.com/nfl-kicker-13-apk/";

        System.out.println(link.hashCode());
    }

    public String reverse(String input){

        StringBuilder sb = new StringBuilder();

        char[] chars = input.toCharArray();

        int j = chars.length-1;

        while(j!=0){
            sb.append(chars[j]);
            j--;
        }

        return sb.toString();
    }

    public String reverseRec(String input){

        if(input.length() == 0){
            return sb.toString();
        } else {
            // If size don't match - extract first character - put into the buffer
            char c = input.charAt(input.length()-1);
            sb.append(c);
            return reverseRec(input.substring(0,input.length()-1));
        }
    }

    StringBuilder sb = new StringBuilder();

}
