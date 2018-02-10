package designPatterns.statePattern;

/**
 * 糖果机状态类接口：糖果机的所有动作都和其状态有关系
 */
public interface State {
    //投入25分硬币
   void insert25();
   //退出25分硬币
   void eject25();
   //转动曲柄
    void turnCrank();
    //发糖果
    void dispense();
}
