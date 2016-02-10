package misc;

import junit.framework.TestCase;

/**
 * Created by dhavalchauhan on 10/14/14.
 */
public class LongTest extends TestCase {
    public void testCast(){

        String url = null;
//        String url = "http://www.androlib.com/r.aspx?r=nike";
        System.out.println(url);

        if(url != null && url.endsWith("/")){
            url = url.substring(0,url.length()-1);
        }

        System.out.println(url);
    }
}
