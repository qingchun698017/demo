package designPatterns.strategyMode;

/**
 * Created by wqc on 2017/10/3.
 * 具体算法策略：斧头（使用的武器）
 */
public class AxeBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("use axe .........");
    }
}
