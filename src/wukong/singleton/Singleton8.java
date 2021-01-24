package wukong.singleton;

/**
 * 枚举写法 【最佳，生产常用】
 */
public enum Singleton8 {

    INSTANCE;

    public void onemethod() {
        System.out.println("不大明白：" + INSTANCE.toString());
    }
}
