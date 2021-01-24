package thread_cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * CyclicBarrier：一组线程互相等待，屏障点就是各线程执行await()处，当执行await的线程达到个数后，各线程均冲破屏障，
 * 各自执行await后面的代码，并且主线程执行钩子函数
 *
 * 示例：十个人，每到达5个人后就坐车出发
 */
public class BarrierDemo {

    public static void main(String[] args) {

        // 钩子函数
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("主线程钩子函数开始");
                System.out.println("主线程钩子函数结束");
            }
        };

        CyclicBarrier barrier = new CyclicBarrier(5, runnable);

        ExecutorService executor = Executors.newCachedThreadPool();

        // 5个人一波，最后2个人等不齐5个人，会抛出timeout异常
        for (int i = 0; i < 12; i++) {
            executor.submit(new Student(i+1, barrier));
        }

        executor.shutdown();

    }

}
