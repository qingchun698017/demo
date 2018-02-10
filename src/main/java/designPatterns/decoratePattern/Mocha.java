package designPatterns.decoratePattern;

/**
 * Created by wqc on 2017/10/14.
 * 装饰者:调料--摩卡
 */
public class Mocha extends CondimentDecorator{
    Beverage beverage;
    public Mocha(Beverage beverage)
    {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+",Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost()+0.20;
    }
}
