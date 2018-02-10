package designPatterns.iteratorPattern;

import java.util.Iterator;

//女招待类，打印菜单
public class Waitress {
    Menu pancakeHouseMenu;
    Menu dinnerMenu;
    public Waitress(Menu pancakeHouseMenu, Menu dinnerMenu)
    {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinnerMenu = dinnerMenu;
    }

    public void printMenu()
    {
       Iterator panIterator = pancakeHouseMenu.createIterator();
       Iterator dinnerIterator = dinnerMenu.createIterator();
       System.out.println("pancakeHouse Menu:");
       printMenu(panIterator);
       System.out.println("\n");
       System.out.println("dinner Menu:");
       printMenu(dinnerIterator);
    }
    private void printMenu(Iterator iterator)
    {
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
}
