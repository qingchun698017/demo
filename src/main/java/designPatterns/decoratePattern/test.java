package designPatterns.decoratePattern;

/**
 * Created by wqc on 2017/10/14.
 * 装饰模式：动态的将责任附加到对象上。若要扩展功能，装饰者提供比继承更有弹性的替代方案
 * 1）装饰者和被装饰者有相同的超类型
 * 2）装饰者可以在所委托被装饰者的行为之前/之后，加上自己的行为，以达到特定的目的。
 */
public class test {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription()+"---"+beverage.cost());

        beverage = new Soy(beverage);
        System.out.println(beverage.getDescription()+"---"+beverage.cost());

        beverage = new Mocha(beverage);
        System.out.println(beverage.getDescription()+"---"+beverage.cost());

    }
}
