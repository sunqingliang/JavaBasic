package thread_create.secondway;

import thread_create.Punishment;

public class StudentClient2 {

    public static void main(String[] args) {

        Punishment punishment = new Punishment(100, "internationlization");

        Student2 xiaozhang = new Student2("小张", punishment);
        Student2 xiaoli = new Student2("小李", punishment);
        Student2 xiaowang = new Student2("小王", punishment);

        new Thread(xiaozhang, "小张").start();
        new Thread(xiaoli, "小李").start();
        new Thread(xiaowang, "小王").start();

        System.out.printf("Main 线程结束\n");

    }
}
