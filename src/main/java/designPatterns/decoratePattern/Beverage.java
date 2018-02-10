package designPatterns.decoratePattern;

/**
 * Created by wqc on 2017/10/14.
 * 饮料的超类：只包含饮料的描述方法description和计算价格的方法cost
 */
public abstract  class Beverage {
    String description = "Unknown Beverage";

    public String getDescription()
    {
        return description;
    }

    public abstract double cost();
}
