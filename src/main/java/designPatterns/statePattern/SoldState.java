package designPatterns.statePattern;

/**
 * 糖果机具体状态类：出售糖果
 *
 * */
public class SoldState implements State {
    GumballMachine gumballMachine;
    public SoldState(GumballMachine gumballMachine)
    {
        this.gumballMachine = gumballMachine;
    }
    @Override
    public void insert25() {
        System.out.println("Please wait, we`re already giving you a gumball.");
    }

    @Override
    public void eject25() {
        System.out.println("Sorry,you are alread turned the Crank!");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn`t get you anthor gumball!");
    }

    @Override
    public void dispense() {
        releaseGumball();
        if(gumballMachine.getCount()>0){
            gumballMachine.setState(gumballMachine.getNot25State());
        }else{
            System.out.println("gumball is sold out!");
        }
    }

    //释放糖果
    private void releaseGumball(){
        System.out.println("A gumball comes rolling out ....");
        if(gumballMachine.getCount() > 0){
            gumballMachine.setCount(gumballMachine.getCount() -1);
        }
    }
}
