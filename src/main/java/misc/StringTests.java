package misc;

import junit.framework.TestCase;

/**
 * Created by dhavalchauhan on 10/13/14.
 */
public class StringTests extends TestCase {

    public void testSplit(){
        String proxy = "10.198.151.227:";

        String[] temp = proxy.split(":");

        if(temp.length == 2){
            System.out.println(temp[0]);
            System.out.println(temp[1]);
        } else {
            System.out.println("Invalid string");
        }
    }

}
