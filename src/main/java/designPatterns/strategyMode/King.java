package designPatterns.strategyMode;

/**
 * Created by wqc on 2017/10/3.
 * 使用算法策略的用户（这里指使用工具的人）具体实现类
 *
 */
public class King extends Charactor {
    public void fight() {
        System.out.println("King fight......");
        weapon.useWeapon();
    }
}
