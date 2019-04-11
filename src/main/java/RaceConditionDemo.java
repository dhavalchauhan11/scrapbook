/**
 * Author: dchauhan
 * Date: 5/8/16.
 */
public class RaceConditionDemo {

    public static void main(String[] args) throws InterruptedException {
        // Create single instance of the counter

        Counter counter = new RaceConditionDemo().new Counter();

        Thread thread1 = new Thread(new RaceConditionDemo().new Processor(counter));
        thread1.setName("add thread1");
        thread1.start();

        Thread thread2 = new Thread(new RaceConditionDemo().new Processor(counter));
        thread2.setName("add thread2");
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter.value());

    }

    class Counter{
        long counter = 0;
        public synchronized void increment(){
            counter++;
        }

        public void decrement(){
            counter--;
        }

        public long value(){
            return counter;
        }
    }

    class Processor implements Runnable{

        Counter counter;

        Processor(Counter counter){
            this.counter = counter;
        }

        public void run() {
            for ( int i=0; i<1000000; i++ ) {
                counter.increment();
            }
        }
    }

}
