package designPatterns.complex;



/**
 * RubberDuck 橡皮鸭
 *
 * @author wqc
 * @create 2017-12-09 16:57
 **/
public class RubberDuck implements Quackable{
    Observable observable;

    public RubberDuck(){
        observable = new Observable(this);
    }
    @Override
    public void quack() {
        System.out.println("橡皮鸭 Squeak!");
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
        return "橡皮鸭";
    }
}
