package ch1;

/**
 * Created by dhavalchauhan on 8/18/15.
 */
public class CStyleStringReverse {
    public static void main(String[] args) {
        String s = "this is test string";
        System.out.println(s);
//        System.out.println(reverse(s));
//        System.out.println(reverse2(s));
        System.out.println(reverse3(s));

    }

    public static String reverse(String s){
        char[] data = s.toCharArray();

        int i = 0;
        int j = data.length - 1;

        char temp;

        while(i < j){
            temp = data[i];
            data[i] = data[j];
            data[j] = temp;
            i++;
            j-- ;
        }

        String ret = new String(data);
        return ret;

    }

    public static String reverse2(String reverseMe){
        for (int i = 0; i < reverseMe.length(); i++) {
            System.out.println(reverseMe.substring(1, reverseMe.length() - i));
            System.out.println(reverseMe.substring(0, 1));
            System.out.println(reverseMe.substring(reverseMe.length() - i, reverseMe.length()));


            reverseMe = reverseMe.substring(1, reverseMe.length() - i)
                    + reverseMe.substring(0, 1)
                    + reverseMe.substring(reverseMe.length() - i, reverseMe.length());
        }
        return reverseMe;
    }

    public static String reverse3(String s) {
        for(int i = 0; i < s.length(); i++)
        {
            s = s.substring(1, s.length() - i) + s.charAt(0) + s.substring(s.length() - i);
        }
        return s;
    }
}
