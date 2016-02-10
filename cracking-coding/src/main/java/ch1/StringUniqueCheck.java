package ch1;

/**
 * Created by dhavalchauhan on 8/17/15.
 */
public class StringUniqueCheck {

    public static void main(String[] args) {
        boolean bol = isUniqueChar("abcd");

//        boolean[] temp = new boolean[3];
//        temp[2] = true;
//        temp[1] = false;
//
//        if(temp[2])
            System.out.println("true");

    }

    public static boolean isUniqueChar(String s){
        boolean[] charSet = new boolean[256];
        for(int i=0;i<s.length();i++){
            int val = s.charAt(i);

            if(charSet[val])
                return false;
            charSet[val] = true;
        }
        return true;
    }

}
