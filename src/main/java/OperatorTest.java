/**
 * Created by dhavalchauhan on 12/10/13.
 */
public class OperatorTest {
    public static int method(long x, long y){

        int metric = 0;
        long val = x^y;

        while(val != 0){
            ++metric;
            if (val > Long.MIN_VALUE){
                val &= val -1;
            } else{
                val &= (~val);
            }
        }

        return metric;
    }

    public static void main(String args[]){
        OperatorTest test = new OperatorTest();
        System.out.println(test.method(3L,5L));
    }

}
