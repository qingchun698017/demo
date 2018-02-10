package designPatterns.observerMode;

/**
 * Created by wqc on 2017/10/5.
 * 定义了对象之间的一对多的依赖，这样一来，当一个对象改变状态时，它的所有依赖者都会收到通知并自动更新。
 */
public class WeatherChangeTest {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditonsDisplay cu = new CurrentConditonsDisplay(weatherData);

        weatherData.setTempt((float) 11.5);

        weatherData.setTempt((float) 22.5);
    }

}
