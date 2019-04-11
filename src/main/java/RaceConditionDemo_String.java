/**
 * Author: dchauhan
 * Date: 5/8/16.
 */
public class RaceConditionDemo_String {

    public static void main(String[] args) throws InterruptedException {

        MyString myString = new RaceConditionDemo_String().new MyString();

        Thread t1 = new Thread(new RaceConditionDemo_String().new MyRunnable(myString,"thread1 "));
        t1.start();

        Thread t2 = new Thread(new RaceConditionDemo_String().new MyRunnable(myString, " thread2 "));
        t2.start();

        Thread t3 = new Thread(new RaceConditionDemo_String().new MyRunnable(myString, " thread3 "));
        t3.start();


        t1.join();
        t2.join();
        t3.join();

        System.out.println(myString.sb.toString());

    }

    public class MyRunnable implements Runnable{
        MyString instance = null;
        String value;

        public MyRunnable(MyString instance, String value){
            this.instance = instance;
            this.value = value;
        }

        public void run(){
            this.instance.add(value);
        }
    }

    public class MyString{
        StringBuilder sb = new StringBuilder();

        public void add(String text){
            this.sb.append(text);
        }
    }
}
