package designPatterns.decoratePattern;

/**
 * Created by wqc on 2017/10/14.
 * 装饰者--调料的超类:所有的调料都需重新描述方法
 */
public abstract class CondimentDecorator extends Beverage{
    public abstract String getDescription();
}
