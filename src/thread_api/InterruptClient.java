package thread_api;

public class InterruptClient {

    public static void main(String[] args) throws InterruptedException {

        // 1. interruput中断的不是线程逻辑
        /*Thread thread = new Thread(()->{
            for(int i=0; i<100 ;i++){
                System.out.println("I'm doing my work");
                System.out.println("I'm interrupted?"+Thread.currentThread().isInterrupted());
            }
        });
        thread.start();
        Thread.sleep(1);
        thread.interrupt();*/

        // 2. interrupt方法中断的不是线程，而是可中断方法（如sleep）。可中断方法被中断后，会把interrupted状态归位，置回false
        /*Thread xiaopang = new Thread(()->{
            for(int i=0; i<10 ;i++){
                System.out.println("I'm doing my work");
                try {
                    System.out.println("I will sleep");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Boring! My sleeping was interrupted");
                }
                System.out.println("I'm interrupted?"+Thread.currentThread().isInterrupted());
            }
        });
        xiaopang.start();
        Thread.sleep(1);
        xiaopang.interrupt();*/

        // 3. Thread.interrupted()获取是否中断的标志，然后置为false
        Thread thread3 = new Thread(()->{
            for(int i=0; i<100 ;i++){
                System.out.println("I'm doing my work");
                // System.out.println("I'm interrupted?"+Thread.currentThread().isInterrupted());
                System.out.println("I'm interrupted?" + Thread.interrupted());
            }
        });
        thread3.start();
        Thread.sleep(2);
        thread3.interrupt();
    }

}
