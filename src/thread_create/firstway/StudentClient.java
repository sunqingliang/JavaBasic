package thread_create.firstway;

import thread_create.Punishment;

public class StudentClient {

    public static void main(String[] args) {

        Punishment punishment = new Punishment(50, "internationlization");

        Student xiaoming = new Student("小明", punishment);

        xiaoming.start();

        System.out.printf("main 线程结束\n");
    }

}
