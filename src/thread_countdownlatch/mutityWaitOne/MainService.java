package thread_countdownlatch.mutityWaitOne;

import java.util.concurrent.CountDownLatch;

/**
 * 多等一。
 * 主线程先创建一个latch(1)
 * 然后每个运动员线程都latch.await()进行等待，裁判员一声令下latch.countDown()，所有运动员开启跑步！
 */
public class MainService {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 6; i++) {
            Runnable runnable = new SportsmanRunnable(i, latch);
            (new Thread(runnable)).start();
        }
        // 裁判准备3秒
        Thread.sleep(3000);
        // 裁判发枪
        latch.countDown();
    }
}
