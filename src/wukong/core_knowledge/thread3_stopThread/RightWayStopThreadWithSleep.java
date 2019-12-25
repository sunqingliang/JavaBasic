package wukong.core_knowledge.thread3_stopThread;

/**
 * 描述：run方法内有sleep时，如何中断
 */
public class RightWayStopThreadWithSleep implements Runnable {

    @Override
    public void run() {
        int num = 0;
        while (num <= 1000) {
            if (num % 100 == 0) {
                System.out.println(num + "是100的倍数");
            }
            num++;
        }
        try {
            // 注意，只要其它线程interrupt过本线程，此处就会抛出异常，哪怕其它线程interrupt的时刻本线程正在处理业务逻辑
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("sleep被中断:" + e.getMessage());
        }
        System.out.println("任务运行结束了");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithSleep());
        thread.start();
        Thread.sleep(2);
        thread.interrupt();
    }
}
