package designPatterns.iteratorPattern;

import java.util.Iterator;
import java.util.function.Consumer;

//午餐菜单迭代器
public class DinnerMenuIterator implements Iterator {
    MenuItem[] menuItems;
    int position = 0;

    public DinnerMenuIterator(MenuItem[] items)
    {
        menuItems = items;
    }
    public boolean hasNext() {
        if(position>=menuItems.length||menuItems[position]==null)
        {
            return false;
        }else{
            return true;
        }

    }

    public Object next() {
        MenuItem menuItem = menuItems[position];
        position = position+1;
        return menuItem;
    }

    public void remove() {
        if(position <=0)
        {
            throw new IllegalStateException
                    ("You can't remove an item until you've done at least one next().");
        }

        if(menuItems[position-1]!=null)
        {
            for(int i = position -1;i<menuItems.length-1;i++)
            {
                menuItems[i]=menuItems[i+1];
            }
            menuItems[menuItems.length-1]=null;
        }
    }

    public void forEachRemaining(Consumer action) {

    }
}
