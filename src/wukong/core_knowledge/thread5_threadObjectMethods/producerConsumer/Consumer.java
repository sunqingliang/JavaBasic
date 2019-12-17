package wukong.core_knowledge.thread5_threadObjectMethods.producerConsumer;

public class Consumer implements Runnable {

    @Override
    public void run() {

        while (true) {

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (testPC.productQuene) {

                // 如果队列里有产品，消费产品
                if (testPC.productQuene.size() > 0) {

                    System.out.println("消费者" + Thread.currentThread().getName() + "消费了产品" + testPC.productQuene.get(testPC.productQuene.size() - 1));
                    testPC.productQuene.remove(testPC.productQuene.size() - 1);
                } else {
                    System.out.println("消费者" + Thread.currentThread().getName() + "等待...");
                    try {
                        testPC.productQuene.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

    }
}
