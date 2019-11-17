package thread_create.testany;

public class CountIncrement implements Runnable {

    public int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            count ++;
        }
    }
}
