package designPatterns.templatePattern;

/*
模板方法：定义了一个算法的步骤，并允许子类为一个或多个步骤提供实现。
在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中。
模板方法使得可以在不改变算法的结构情况下，重新定义算法的某些步骤。
 */
public class Test {
    public static void main(String[] args) {
        Tea tea = new Tea();
        Coffee coffee = new Coffee();

        System.out.println("tea  prepareRecipe:");
        tea.prepareRecipe();

        System.out.println("coffee prepareRecipe:");
        coffee.prepareRecipe();

    }



}
