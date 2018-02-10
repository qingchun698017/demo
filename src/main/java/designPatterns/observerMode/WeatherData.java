package designPatterns.observerMode;

import java.util.ArrayList;

/**
 * Created by wqc on 2017/10/5.
 */
public class WeatherData implements Subject {

    private ArrayList observers;
    private float tempt;

    public WeatherData()
    {
        observers = new ArrayList();
    }
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i>=0)
        {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for(int i = 0;i<observers.size();i++)
        {
            Observer o = (Observer) observers.get(i);
            o.update(tempt);
        }
    }


    public void temptChange()
    {
        notifyObservers();
    }

    public void setTempt(float tempt)
    {
        this.tempt = tempt;
        temptChange();
    }
}
