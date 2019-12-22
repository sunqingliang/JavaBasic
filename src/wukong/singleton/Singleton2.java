package wukong.singleton;

/**
 * 饿汉式（静态代码块）【可用】
 */
public class Singleton2 {

    private static final Singleton2 INSTANCE;

    static {
        INSTANCE = new Singleton2();
    }

    private Singleton2 () {
        System.out.println("gouzao2");
    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }

}
