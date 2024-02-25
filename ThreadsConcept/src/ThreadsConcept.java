/*Creation of Thread in Java by extending Thread class*/

public class ThreadsConcept {
    public static void main(String[] args) {
        MyClass m1 = new MyClass();
        MyClass m2 = new MyClass();
        m1.start();
        m2.start();
    }
}
