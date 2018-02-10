package designPatterns.strategyMode;

/**
 * Created by wqc on 2017/10/3.
 * 策略模式：定义了算法族，分别分装起来，让它们之间可以相互替换，此模式让算法的变化可以独立于使用算法的用户。
 */
public class test {
    public static void main(String[] args) {
        Charactor king = new King();
        WeaponBehavior sw = new SwordBehavior();
        king.setWeapon(sw);
        king.fight();

        WeaponBehavior axe = new AxeBehavior();
        king.setWeapon(axe);
        king.fight();
    }
}
