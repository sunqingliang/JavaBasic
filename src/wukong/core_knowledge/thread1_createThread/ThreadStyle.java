package wukong.core_knowledge.thread1_createThread;

/**
 * 描述：     用Thread方式实现线程
 */
public class ThreadStyle extends Thread{

    @Override
    public void run() {
        System.out.println("通过直接继承Thread类来创建线程");
    }

    public static void main(String[] args) {
//        new ThreadStyle().start();
        ThreadStyle t1 = new ThreadStyle();
        t1.start();
    }
}





