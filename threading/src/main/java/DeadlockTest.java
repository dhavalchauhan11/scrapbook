/**
 * Author: dchauhan
 * Date: 5/9/16.
 */
public class DeadlockTest {
    public static Object obj1 = new Object();
    public static Object obj2 = new Object();

    public static void main(String[] a) throws InterruptedException {
        Thread t1 = new Thread1();
//        Thread t2 = new Thread2();
        Thread t2 = new Thread2_DL_Solved();
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("The End...");
    }

    private static class Thread1 extends Thread{
        public void run(){
            synchronized (obj1){
                System.out.println("Thread 1:: acquiring lock on object 1...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 1:: waiting for lock on object 2...");
                synchronized (obj2){
                    System.out.println("Thread 1:: holding lock on object 1 & 2");
                }
            }
        }
    }

//    private static class Thread2 extends Thread{
//        @Override
//        public void run() {
//            synchronized (obj2){
//                System.out.println("Thread 2:: acquiring lock on object 2...");
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                System.out.println("Thread 2:: waiting for lock on object 1...");
//                synchronized (obj1){
//                    System.out.println("Thread 2:: holding lock on object 1 & 2");
//                }
//            }
//        }
//    }

    private static class Thread2_DL_Solved extends Thread{
        @Override
        public void run() {
            synchronized (obj1){
                System.out.println("Thread 2:: acquiring lock on object 1...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 2:: waiting for lock on object 2...");
                synchronized (obj2){
                    System.out.println("Thread 2:: holding lock on object 1 & 2");
                }
            }
        }
    }
}
