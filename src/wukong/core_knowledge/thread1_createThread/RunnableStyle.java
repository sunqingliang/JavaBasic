package wukong.core_knowledge.thread1_createThread;

/**
 * 描述：     用Runnable方式创建线程
 */
public class RunnableStyle implements Runnable{

    @Override
    public void run() {
        System.out.println("通过实现Runnable接口来创建线程");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }
}
