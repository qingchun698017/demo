package designPatterns.complex;



/**
 * DuckCall 鸭鸣器
 *
 * @author wqc
 * @create 2017-12-09 16:55
 **/
public class DuckCall implements Quackable{
    Observable observable;

    public DuckCall(){
        observable = new Observable(this);
    }
    @Override
    public void quack() {
        System.out.println("鸭鸣器 Kwakkk!");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }

    @Override
    public String toString() {
        return "鸭鸣器";
    }
}
