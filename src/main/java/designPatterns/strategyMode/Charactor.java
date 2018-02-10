package designPatterns.strategyMode;

/**
 * Created by wqc on 2017/10/3.
 * 使用算法策略的用户（这里指使用工具的人）抽象类
 */
public abstract class Charactor {
    WeaponBehavior weapon;

    public void fight() {

    }

    public void setWeapon(WeaponBehavior w)
    {
        this.weapon = w;
    }

}
