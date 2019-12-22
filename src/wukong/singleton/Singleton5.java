package wukong.singleton;

/**
 * 懒汉式（线程不安全）【不可用】
 */
public class Singleton5 {

    private static Singleton5 instance;

    private Singleton5() {

    }

    public static Singleton5 getInstance() {

        if (instance == null) {
            // 此处仍会线程不安全，两个线程同时到达这里后，两线程最终都会创建出实例
            synchronized (instance) {
                return new Singleton5();
            }
        }
        return instance;
    }
}
