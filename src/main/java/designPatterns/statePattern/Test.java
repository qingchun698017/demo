package designPatterns.statePattern;
/**
 * 状态模式：允许对象在内部状态改变时改变它的行为，对象看起来好像修改了它的类
 * 适用性：
 *  1.一个对象的行为取决于它的状态,并且它必须在运行时刻根据状态改变它的行为。

    2.一个操作中含有庞大的多分支的条件语句，且这些分支依赖于该对象的状态。

   参与者：
    1、Context（GumballMachine）:定义客户感兴趣的接口（行为方法）。拥有一些内部状态。维护一个State实例,这个实例定义当前状态。
    2、State:定义了一个所有具体状态的共同接口；任何状态都实现这个这个共同的接口，这样状态间可以相互切换。
    3、ConcreteState:状态子类

    例子：糖果机不同状态的行为输出
 */
public class Test {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);
        gumballMachine.insert25();
        gumballMachine.turnCrank();
        System.out.println("---------------"+gumballMachine.toString());
        gumballMachine.eject25();
    }
}
