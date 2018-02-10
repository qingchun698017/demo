package designPatterns.complex;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Observable
 *
 * @author wqc
 * @create 2017-12-09 19:24
 **/
public class Observable implements QuackObservable {
    List observers = new ArrayList();
    QuackObservable duck;

    public Observable(QuackObservable duck){
        this.duck = duck;
    }
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        Iterator iterator = observers.iterator();
        while (iterator.hasNext()){
            Observer observer = (Observer) iterator.next();
            observer.update(duck);
        }
    }
}
