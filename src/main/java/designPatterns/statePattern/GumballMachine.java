package designPatterns.statePattern;

/**
 * 实例类：糖果机 包含4种状态：有25分钱、没有25分钱、出售糖果、没有糖果停止出售
 */
public class GumballMachine {
    State has25State;
    State not25State;
    State soldState;

    State state;
    int count = 0;//现存糖果数
    public GumballMachine(int numberGumball){
        has25State = new Has25State(this);
        not25State = new Not25State(this);
        soldState = new SoldState(this);

        state=not25State;
        count = numberGumball;
    }

    //投入25分硬币
   public void insert25(){
        state.insert25();
   }
    //退出25分硬币
   public void eject25(){
        state.eject25();
   }
    //转动曲柄
   public void turnCrank(){
        state.turnCrank();
        state.dispense();
   }


    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getHas25State() {
        return has25State;
    }

    public void setHas25State(State has25State) {
        this.has25State = has25State;
    }

    public State getNot25State() {
        return not25State;
    }

    public void setNot25State(State not25State) {
        this.not25State = not25State;
    }

    public State getSoldState() {
        return soldState;
    }

    public void setSoldState(State soldState) {
        this.soldState = soldState;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "state=" + state +
                ", count=" + count +
                '}';
    }
}
