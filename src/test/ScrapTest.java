/**
 * Author: dchauhan
 * Date: 6/16/16.
 */
public class ScrapTest {

    public static void main(String[] args) {
        Long l1 = new Long(123);
        Long l2 = new Long(123);

        if(l1.equals(l2)){
            System.out.println("Equals - equals");
        }

        if(l1 == l2){
            System.out.println("== - equals");
        }
    }
}
