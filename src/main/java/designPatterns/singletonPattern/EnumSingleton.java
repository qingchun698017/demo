package designPatterns.singletonPattern;

/**
 * Created by wqc on 2017/10/14.
 * 枚举单例：可以避免多线程同步问题，而且还能防止反序列化重新创建新的对象
 */
public enum  EnumSingleton {
    INSTANCE;
    public void whateverMethod() {
    }
}
