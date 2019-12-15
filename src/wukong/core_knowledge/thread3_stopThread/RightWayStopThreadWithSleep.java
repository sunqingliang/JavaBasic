package wukong.core_knowledge.thread3_stopThread;

/**
 * 描述：     run方法内有sleep时，如何中断
 */
public class RightWayStopThreadWithSleep implements Runnable {

    @Override
    public void run() {
        int num = 0;
        while (num <= 300) {
            if (num % 100 == 0) {
                System.out.println(num + "是100的倍数");
            }
            num++;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务运行结束了");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithSleep());
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}
