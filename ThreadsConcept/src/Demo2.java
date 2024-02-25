/* Creation of Thread in Java by implementing Runnable Interface */

public class Demo2{
    public static void main(String[] args) {
        Thread t1 = new Thread(new Dummy());
        Thread t2 = new Thread(new Dummy());
        t1.start();
        t2.start();
    }
}
