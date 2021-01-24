package thread_cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Student implements Runnable {

    private int id;
    private CyclicBarrier barrier;

    public Student(int id, CyclicBarrier barrier) {
        this.id = id;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            // System.out.println("Student." + id + "正在赶来...");
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("Student." + id + "到达");
            // 等5个人到齐
            barrier.await(10, TimeUnit.SECONDS);
            System.out.println("Student." + id + "说：人到齐了，我上车了哈");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
