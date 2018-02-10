package designPatterns.singletonPattern;

/**
 * Created by wqc on 2017/10/14.
 * http://cantellow.iteye.com/blog/838473
 * 单例模式：只有一个对象，提供一个全局访问点
 * 1)Singleton类被装载了，instance不一定被初始化。因为SingletonHolder类没有被主动使用，
 * 只有显示通过调用getInstance方法时，才会显示装载SingletonHolder类，从而实例化instance
 *
 * 2)如果Singleton实现了java.io.Serializable接口，那么这个类的实例就可能被序列化和复原。
 * 不管怎样，如果你序列化一个单例类的对象，接下来复原多个那个对象，那你就会有多个单例类的实例。
 */
public class Singleton {
    private Singleton()
    {

    }

    public static final Singleton getIntance()
    {
        return InnerSinglenton.singleton;
    }
    private static class InnerSinglenton{
        private static final Singleton singleton = new Singleton();

    }

}

