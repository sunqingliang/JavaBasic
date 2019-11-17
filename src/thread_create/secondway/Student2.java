package thread_create.secondway;

import thread_create.Punishment;

import java.util.Random;

public class Student2 implements Runnable {

    private String name;
    private Punishment punishment;

    public Student2(String name, Punishment punishment) {
        this.name = name;
        this.punishment = punishment;
    }

    public void copyWord() {
        int count = 0;
        String threadName = Thread.currentThread().getName();

        while (true) {
//            synchronized (punishment) {
                int leftCopyCount = punishment.getLeftCopyCount();
                if (leftCopyCount > 0) {
                    try {
                        // 抄单词
                        Thread.sleep((new Random()).nextInt(40)+60);
                        System.out.println(threadName+"线程-"+name + "抄写" + punishment.getWordToCopy());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    leftCopyCount--;
                    if (leftCopyCount < punishment.getLeftCopyCount()) {
                        punishment.setLeftCopyCount(leftCopyCount);
                    }
//                    System.out.println(threadName+"线程-"+name + "抄写" + punishment.getWordToCopy() + "。还要抄写" + leftCopyCount + "次");
                    count++;
                } else {
                    break;
                }
//            }
        }

        System.out.println(threadName+"线程-"+name + "一共抄写了" + count + "次！");
    }

    @Override
    public void run() {
        copyWord();
    }

}
