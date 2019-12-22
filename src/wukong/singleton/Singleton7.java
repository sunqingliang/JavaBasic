package wukong.singleton;

/**
 * 静态内部类方式，可用
 * 懒加载--当真正调用getInstance时，实例才会被初始化；线程安全
 */
public class Singleton7 {

    private Singleton7 () {

    }

    private static class SingletonInstance {
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    public static Singleton7 getInstance() {
        return SingletonInstance.INSTANCE;
    }

}
