package designPatterns.observerMode;

/**
 * Created by wqc on 2017/10/5.
 */
public interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();

}
