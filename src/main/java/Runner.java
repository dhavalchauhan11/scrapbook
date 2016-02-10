import chap1.chap1_1;

/**
 * Created by dhavalchauhan on 1/23/14.
 */
public class Runner {
    public static void main(String args[]){
        checkUniqueness();

    }

    private static void checkUniqueness() {
        String input = "abcdpqac";

        chap1_1 test = new chap1_1();
        boolean bol = test.checkUniqueness(input);
        System.out.println(bol);
    }
}
