package designPatterns.observerMode;

/**
 * Created by wqc on 2017/10/5.
 */
public class CurrentConditonsDisplay implements Observer {
    private float tempt;
    private Subject weatherData;

    public CurrentConditonsDisplay(Subject weatherData)
    {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void update(float tempt) {
        this.tempt = tempt;
        display();
    }

    public void display()
    {
        System.out.println("Current tempt is:"+ tempt);
    }
}
