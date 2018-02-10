package designPatterns.complex;



/**
 * RedHeadDuck
 *
 * @author wqc
 * @create 2017-12-09 16:50
 **/
public class RedHeadDuck implements Quackable{
    Observable observable;

    public RedHeadDuck(){
        observable = new Observable(this);
    }
    @Override
    public void quack() {
        System.out.println("红头鸭 嘎嘎嘎！");
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
        return "红头鸭";
    }
}
