package wukong.core_knowledge.thread3_stopThread;

/**
 * 描述：     run方法内有sleep并且sleep在while中，直接靠中断抛异常便可退出循环
 */
public class RightWayStopThreadWithSleepEveryLoop implements Runnable {

    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 10000) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace(); // 调用interrupt后，sleep可直接抛出异常，这样就终止了线程
        }
        System.out.println("任务运行结束了");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithSleepEveryLoop());
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
