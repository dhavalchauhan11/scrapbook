package misc;

import java.math.BigDecimal;

/**
 * Created by dhavalchauhan on 5/14/14.
 */
public class BigDecimalTest {

    public static void main(String args[]){
        float price = 0.89f;
        BigDecimal bg = new BigDecimal(price);

        System.out.println(bg.setScale(0, BigDecimal.ROUND_HALF_EVEN));

        System.out.println(Float.toString(price));

    }
}
