package designPatterns.iteratorPattern;

/**
 * 迭代器模式:提供一种方法顺序的访问一个聚合对象中的各个元素，而不暴露其内部的表示
 */
public class Test {
    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinnerMenu dinnerMenu = new DinnerMenu();
        Waitress waitress = new Waitress(pancakeHouseMenu,dinnerMenu);
        waitress.printMenu();

    }
}
