package designPatterns.templatePattern;

/**
 *咖啡因饮料，模板方法
 */
public abstract class CaffeineBeverageWithHook {
    //模板方法,不可重写
    final void prepareRecipe()
    {
        boilWater();
        brew();
        pourInCup();
        if(customerWantsCondiments())
        {
            addCondiments();
        }

    }

    final void boilWater()
    {
        System.out.println("boil water");
    }

    final void pourInCup()
    {
        System.out.println("pour into cup");
    }

    //需要子类实现的方法
    abstract void brew();//

    abstract void addCondiments();

    //钩子方法：可由子类控制是否添加调料
    boolean customerWantsCondiments()
    {
        return true;
    }
}
