package designPatterns.decoratePattern;

/**
 * Created by wqc on 2017/10/14.
 * 被装饰者：饮料的实现类--混合咖啡
 */
public class HouseBlend extends Beverage{

    public HouseBlend()
    {
        description = "House Blend Coffee";
    }
    @Override
    public double cost() {
        return 2.99;
    }
}
