package wukong.core_knowledge.thread5_threadObjectMethods;

public class WaitNotifyAll {
    public static Object obj = new Object();

    static Runnable runnable1 = () -> {
        System.out.println(Thread.currentThread().getName() + " 在sync上一行");
        synchronized (obj) {
            try {
                System.out.println(Thread.currentThread().getName() + " 进入wait");
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 走出了wait");
        }
    };

    static Runnable runnable2 = () -> {
        System.out.println(Thread.currentThread().getName() + " 在sync上一行");
        synchronized (obj) {
            try {
                System.out.println(Thread.currentThread().getName() + " 进入wait");
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 走出了wait");
        }
    };

    static Runnable runnable3 = () -> {
        synchronized (obj) {
            System.out.println(Thread.currentThread().getName() + " 开始notifyAll");
            obj.notifyAll();
            System.out.println(Thread.currentThread().getName() + " 结束notifyAll");
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(runnable1, "线程1");
        Thread t2 = new Thread(runnable2, "线程2");
        Thread t3 = new Thread(runnable3, "线程3");
        t1.start();
        t2.start();
        Thread.sleep(500);
        t3.start();
        System.out.println(Thread.currentThread().getName() + " 结束");
    }
}
