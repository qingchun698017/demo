package designPatterns.statePattern;

/**
 * 糖果机具体状态类：没有25分钱状态
 */
public class Not25State implements State {
    GumballMachine gumballMachine;
    public Not25State(GumballMachine gumballMachine)
    {
        this.gumballMachine = gumballMachine;
    }
    @Override
    public void insert25() {
        System.out.println("You insert  25  ~");
        gumballMachine.setState(gumballMachine.getHas25State());
    }

    @Override
    public void eject25() {
        System.out.println("Not 25 return!");
    }

    @Override
    public void turnCrank() {
        System.out.println("please insert 25!");
    }

    @Override
    public void dispense() {
        System.out.println("can`t dispense!");
    }
}
