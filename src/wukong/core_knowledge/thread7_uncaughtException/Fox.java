package wukong.core_knowledge.thread7_uncaughtException;

public class Fox {

    public static void main(String[] args) {

        MyUncaughtExceptionHandler eh = new MyUncaughtExceptionHandler("networkEH");
        Thread.setDefaultUncaughtExceptionHandler(eh);

        Runnable runnable = () -> {
            System.out.println("执行子线程 " + Thread.currentThread().getName());
            throw new RuntimeException();
        };

        Thread t1 = new Thread(runnable,"t1");
        Thread t2 = new Thread(runnable,"t2");
        Thread t3 = new Thread(runnable,"t3");

        t1.start();
        t2.start();
        t3.start();
    }
}
