package designPatterns.complex;

import javafx.beans.Observable;

/**
 * 呱呱叫接口
 */
public interface Quackable extends QuackObservable{
    public void quack();
}
