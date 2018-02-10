package designPatterns.decoratePattern;

/**
 * Created by wqc on 2017/10/14.
 * 装饰者：调料--豆浆
 */
public class Soy extends CondimentDecorator {
    Beverage beverage;
    public Soy(Beverage beverage)
    {
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+",Soy";
    }

    @Override
    public double cost() {
        return beverage.cost()+0.3;
    }
}
