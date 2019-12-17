package wukong.core_knowledge.thread5_threadObjectMethods;

/**
 * 描述：展示wait和notify的基本用法 1. 研究代码执行顺序 2. 证明wait释放锁
 */
public class WaitNotify {

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
        synchronized (obj) {
            System.out.println(Thread.currentThread().getName() + " 开始notify");
            obj.notify();
            System.out.println(Thread.currentThread().getName() + " 结束notify");
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(runnable1, "线程1");
        Thread t2 = new Thread(runnable2, "线程2");
        t1.start();
        Thread.sleep(500);
        t2.start();
        System.out.println(Thread.currentThread().getName() + " 结束");
    }
}
