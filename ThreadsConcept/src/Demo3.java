/* Demo for synchronized and join to avoid concurrency issues */

public class Demo3 {
    public static int counter = 0;

    public static synchronized void counter() {
        counter++;
    }
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            for(int i=0; i<1000000; i++) {
                counter();
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Value : " + counter);
    }
}
