package designPatterns.complex;


/**
 * GooseAdapter 鹅适配器
 *
 * @author wqc
 * @create 2017-12-09 17:08
 **/
public class GooseAdapter implements Quackable{
    Goose goose;
    Observable observable;

    public GooseAdapter(Goose goose){
        this.goose = goose;
        observable = new Observable(this);
    }
    @Override
    public void quack() {
       goose.honk();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }
}
