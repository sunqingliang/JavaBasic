package wukong.deadlock.transferMoney;

public class TransMoney {

    // 余额
    private int balance;
    // 两个账户
    static Account a = new Account(500);
    static Account b = new Account(500);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(runnable1, "t1");
        Thread t2 = new Thread(runnable2, "t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("转账完成，a余额=" + a.balance + ", b余额=" + b.balance);
    }

    static Runnable runnable1 = () -> {
        transferMoney(a, b, 200);
    };

    static Runnable runnable2 = () -> {
        transferMoney(b, a, 100);
    };

    public static void transferMoney(Account from, Account to ,int amount) {
        synchronized (from) {
            /*try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            synchronized (to) {
                System.out.println(Thread.currentThread().getName() + "进入转账程序...");
                if (from.balance - amount < 0) {
                    System.out.println("余额不足，转账失败。");
                    return;
                }
                from.balance -= amount;
                to.balance = to.balance + amount;
                System.out.println("成功转账" + amount + "元");
            }
        }
    }

}
