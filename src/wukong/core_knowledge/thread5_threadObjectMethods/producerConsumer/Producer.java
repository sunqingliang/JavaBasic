package wukong.core_knowledge.thread5_threadObjectMethods.producerConsumer;

public class Producer implements Runnable {

    @Override
    public void run() {

        while (true) {

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (testPC.productQuene) {
                // 如果队列里有产品，通知消费者消费
                if (testPC.productQuene.size() > 0) {
                    System.out.println("生产者通知大家消费...");
                    testPC.productQuene.notifyAll();
                } else {
                    System.out.println("生产者开始生产aa bb cc");
                    testPC.productQuene.add("aa");
                    testPC.productQuene.add("bb");
                    testPC.productQuene.add("cc");
                    System.out.println("生产者结束生产aa bb cc，并通知大家消费...");
                    testPC.productQuene.notifyAll();
                }
            }
        }
    }
}
