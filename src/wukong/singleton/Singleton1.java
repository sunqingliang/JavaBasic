package wukong.singleton;

/**
 * 饿汉式（静态常量）【可用】
 */
public class Singleton1 {

    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1 () {
        System.out.println("gouzao");
    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }

}
