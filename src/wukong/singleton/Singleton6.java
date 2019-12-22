package wukong.singleton;


/**
 * 双重检测，最为致命 【推荐面试用】
 * 加volatile是为了防止第21行重排序：如果21行重排序了（即先new出了空对象，还未执行构造方法），
 * 此时instance已经不是null了，如果此时另一个线程进入第18行，就会返回错误的instance
 */
public class Singleton6 {

    private static Singleton6 instance;

    private Singleton6 () {

    }

    public static Singleton6 getInstance() {
        if (instance == null) {
            synchronized (Singleton6.class) {
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
