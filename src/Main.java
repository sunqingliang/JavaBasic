import wukong.singleton.Singleton8;

import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
//        access();

        Thread t = new Thread();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void access() {
        lock.lock();
        try {
            if (lock.getHoldCount() < 4) {
                System.out.println("进来了");
                access(); // 执行完这句，不进finally
            }
        } finally {
            System.out.println("解锁");
            lock.unlock();
        }
    }




}
