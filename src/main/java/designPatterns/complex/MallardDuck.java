package designPatterns.complex;



/**
 * MallardDuck 绿头鸭
 *
 * @author wqc
 * @create 2017-12-09 16:39
 **/
public class MallardDuck implements Quackable {
    Observable observable;

    public MallardDuck(){
        observable = new Observable(this);
    }
    @Override
    public void quack() {
        System.out.println("绿头鸭 嘎嘎嘎！");
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
        return "绿头鸭";
    }
}
