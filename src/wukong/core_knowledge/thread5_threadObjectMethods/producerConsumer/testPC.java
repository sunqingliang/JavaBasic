package wukong.core_knowledge.thread5_threadObjectMethods.producerConsumer;

import java.util.ArrayList;
import java.util.List;

public class testPC {

    static public volatile List<String> productQuene = new ArrayList<>();

    public static void main(String[] args) {

        Thread consumer1 = new Thread(new Consumer(), "【小明】");
        Thread consumer2 = new Thread(new Consumer(), "【小李】");
        Thread producer = new Thread(new Producer(), "生产者线程");

        producer.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        consumer1.start();
        consumer2.start();

    }
}
