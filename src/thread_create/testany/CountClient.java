package thread_create.testany;

public class CountClient {

    public static void main(String[] args) throws InterruptedException {

        CountIncrement c1 = new CountIncrement();

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c1);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.printf("count is " + c1.count);
    }
}
