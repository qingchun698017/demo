package designPatterns.iteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;

//煎饼屋菜单
public class PancakeHouseMenu implements Menu {
    private ArrayList menuItems;

    public PancakeHouseMenu()
    {
        menuItems = new ArrayList();
        addItem("zaocan1","rou,shucai,fanxei",2.44,false);
        addItem("zaocan2","rou,fanxei",1.44,false);
        addItem("zaocan3","rou,shucai",2.22,false);
        addItem("zaocan4","shucai,fanxei",0.44,true);
    }

    public void addItem(String name,String description,double price,boolean vegetarian)
    {
        MenuItem menuItem =
                new MenuItem(name,description, price, vegetarian);
        menuItems.add(menuItem);
    }

    @Override
    public Iterator createIterator() {
        return  menuItems.iterator();
    }
}
