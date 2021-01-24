package wukong.core_knowledge.thread7_uncaughtException;

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    private String name;

    public MyUncaughtExceptionHandler(String name) {
        this.name = name;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("捕获器" + name + "发挥作用啦! " + "Thread " + t.getName() + " catch exception! Detail:" + e.getCause());
    }
}
