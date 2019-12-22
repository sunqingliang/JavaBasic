package wukong.singleton;

/**
 * 懒汉式（线程安全）【不推荐用】
 */
public class Singleton4 {

    private static Singleton4 instance;

    private Singleton4 () {

    }

    public static synchronized Singleton4 getInstance() {
        if (instance == null) {
            return new Singleton4();
        }
        return instance;
    }
}
