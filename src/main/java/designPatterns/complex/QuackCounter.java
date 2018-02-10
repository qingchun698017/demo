package designPatterns.complex;



/**
 * QuackCounter 鸭叫计数器
 * 计鸭子叫的次数
 *
 * @author wqc
 * @create 2017-12-09 17:12
 **/
public class QuackCounter implements Quackable {
    Quackable duck;
    static int numberOfQuacks;

    public QuackCounter(Quackable duck){
        this.duck = duck;
    }
    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks++;
    }

    public static int getNumberOfQuacks(){
        return numberOfQuacks;
    }

    @Override
    public void registerObserver(Observer observer) {
        duck.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        duck.notifyObservers();
    }
}
