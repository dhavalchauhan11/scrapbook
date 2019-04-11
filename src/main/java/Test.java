/**
 * Author: dchauhan
 * Date: 5/2/16.
 */
public class Test {

    public static void main(String[] args) {
        Calender[] calArray = new Calender[]{new Calender(1,2,"a"),new Calender(3,5,"c"),new Calender(4,6,"c")};






    }


    private static class Calender{
        int start;
        int end;
        String id;

        public Calender(int start, int end, String id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }
    }

}
