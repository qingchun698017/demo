package designPatterns.decoratePattern;

/**
 * Created by wqc on 2017/10/14.
 * 被装饰者：饮料的实现类--溶缩咖啡
 */
public class Espresso extends Beverage{

    public Espresso()
    {
        description = "Espresso";
    }
    @Override
    public double cost() {
        return 1;
    }
}
