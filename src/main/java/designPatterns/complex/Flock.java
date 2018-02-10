package designPatterns.complex;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Flock 组合鸭子：一群鸭子
 *
 * @author wqc
 * @create 2017-12-09 19:12
 **/
public class Flock implements Quackable {

    List quackers = new ArrayList<Quackable>();

    public void add(Quackable quacker){
        quackers.add(quacker);
    }
    @Override
    public void quack() {
        Iterator iterator = quackers.iterator();
       while (iterator.hasNext()){
           Quackable quackable = (Quackable) iterator.next();
           quackable.quack();
       }
       notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        Iterator iterator = quackers.iterator();
        while (iterator.hasNext()){
            Quackable quackable = (Quackable) iterator.next();
            quackable.registerObserver(observer);
        }
    }

    @Override
    public void notifyObservers() {
        Iterator iterator = quackers.iterator();
        while (iterator.hasNext()){
            Quackable quackable = (Quackable) iterator.next();
            quackable.notifyObservers();
        }
    }


}
