package designPatterns.iteratorPattern;

import java.util.Iterator;

//午餐店菜单
public class DinnerMenu implements Menu {
    static final int MAX_ITEMS = 4;
    int numOfItems = 0;
    MenuItem[] menuItems;

    public DinnerMenu()
    {
        menuItems = new MenuItem[MAX_ITEMS];
        addMenuItem("wucan1","doudou,kaoniupai",6.99,false);
        addMenuItem("wucan2","doudou,kaoniupai",7.99,false);
        addMenuItem("wucan3","doudou,kaoniupai",8.99,false);
    }

    public void addMenuItem(String name,String description,double price,boolean vegetarian)
    {
        MenuItem menuItem = new MenuItem(name,description,price,vegetarian);
        if(numOfItems >= MAX_ITEMS)
        {
            System.out.println("sorry,menu is full.");
        }else{
            menuItems[numOfItems] = menuItem;
            numOfItems = numOfItems + 1;
        }
    }

    @Override
    public Iterator createIterator() {
        return new DinnerMenuIterator(menuItems);
    }
}
