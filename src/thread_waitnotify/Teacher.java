package thread_waitnotify;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Teacher extends Thread {
    private String name;
    private List<String> punishWords = Arrays.asList("internationalization", "hedgehog", "penicillin", "oasis", "nirvana", "miserable");
    private LinkedList<Task> tasks;
    private int MAX = 10;

    public Teacher(String name, LinkedList<Task> tasks) {
        //调用Thread构造方法，设置threadName
        super(name);
        this.name = name;
        this.tasks = tasks;
    }

    public void arrangePunishment() throws InterruptedException {
        String threadName = Thread.currentThread().getName();

        while (true) {
            synchronized (tasks) {
                if (tasks.size() < MAX) {
                    Task task = new Task(new Random().nextInt(3) + 1, getPunishedWord());
                    tasks.addLast(task);
                    System.out.println(threadName + "留了作业，抄写" + task.getWordToCopy() + " " + task.getLeftCopyCount() + "次");
                    tasks.notifyAll();
                } else {
                    System.out.println(threadName+"开始等待");
                    tasks.wait();
                    System.out.println("teacher线程 " + threadName + "线程-" + name + "等待结束");
                }
            }
        }
    }

    //重写run方法，完成任务。
    @Override
    public void run() {
        try {
            arrangePunishment();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getPunishedWord() {
        return punishWords.get(new Random().nextInt(punishWords.size()));
    }
}
