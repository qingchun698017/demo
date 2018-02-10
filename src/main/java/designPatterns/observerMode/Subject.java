package designPatterns.observerMode;

/**
 * Created by wqc on 2017/10/5.
 */
public interface Subject {
    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();

}
