package designPatterns.complex;



/**
 * QuackObservable 被观察者 接口
 *
 * @author wqc
 * @create 2017-12-09 19:20
 **/
public interface QuackObservable {
    public void registerObserver(Observer observer);
    public void notifyObservers();
}
