package designPatterns.statePattern;

/**
 * 糖果机具体状态类：有25分钱状态
 */
public class Has25State implements State {
    GumballMachine gumballMachine;
    public Has25State(GumballMachine gumballMachine)
    {
        this.gumballMachine = gumballMachine;
    }
    @Override
    public void insert25() {
        System.out.println("You can`t insert anthor 25!");
    }

    @Override
    public void eject25() {
        System.out.println("25 returned!");
        gumballMachine.setState(gumballMachine.getNot25State());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("can`t dispense!");
    }
}
