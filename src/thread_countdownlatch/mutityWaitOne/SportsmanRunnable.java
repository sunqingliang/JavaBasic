package thread_countdownlatch.mutityWaitOne;

import java.util.concurrent.CountDownLatch;

public class SportsmanRunnable implements Runnable {

    private Integer id;
    private CountDownLatch latch;

    @Override
    public void run() {
        try {
            System.out.println("No." + id + "等待跑步");
            latch.await();
            System.out.println("No." + id + "开始跑步");
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("No." + id + "结束跑步");
        } catch (InterruptedException e) {
            System.out.println(id + e.getMessage());
        }
    }

    public SportsmanRunnable(Integer id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }
}
