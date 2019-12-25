package wukong.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 描述：必定发生死锁的情况（自己写的）
 */
public class MustDeadLock2 {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(runnable1, "t1");
        Thread t2 = new Thread(runnable2, "t2");

        t1.start();
        t2.start();

        // 后续章节的内容：用ThreadMXBean检测死锁
        Thread.sleep(1000);
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
        if (deadlockedThreads != null && deadlockedThreads.length > 0) {
            for (int i = 0; i < deadlockedThreads.length; i++) {
                ThreadInfo threadInfo = threadMXBean.getThreadInfo(deadlockedThreads[i]);
                System.out.println("发现死锁" + threadInfo.getThreadName());
            }
        }
    }

    static Runnable runnable1 = () -> {
        System.out.println("jinru t1");
        synchronized (lock1) {
            System.out.println("t1 get lock1");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock2) {
                System.out.println("t1 get lock2");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1 release lock2");
        }
        System.out.println("t1 release lock1");
    };

    static Runnable runnable2 = () -> {
        System.out.println("jinru t2");
        synchronized (lock2) {
            System.out.println("t2 get lock2");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock1) {
                System.out.println("t2 get lock1");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 release lock1");
        }
        System.out.println("t2 release lock2");
    };

}
