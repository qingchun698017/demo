package offer;

import java.util.Stack;

/**
 * Created by wqc on 2017/7/24.
 * 实现一个栈结构，该栈的min函数可返回该栈的最小值，
 * 调用pop、min、push的德尔时间复杂度都是O(1)
 * 使用一个辅助栈来保存最小元素，这个解法简单不失优雅。设该辅助栈名字为minimum stack，其栈顶元素为当前栈中的最小元素。这意味着

 要获取当前栈中最小元素，只需要返回minimum stack的栈顶元素即可。
 每次执行push操作，检查push的元素是否小于或等于minimum stack栈顶元素。如果是，则也push该元素到minimum stack中。
 当执行pop操作的时候，检查pop的元素是否与当前最小值相等。如果相同，则需要将改元素从minimum stack中pop出去。
 * */
public class Problem21_minStack {
    Stack<Integer> minStack;
    Stack<Integer> dataStack;

    void push(Integer i)
    {
        if(minStack.isEmpty() || dataStack.isEmpty())
        {
            minStack.push(i);
            dataStack.push(i);
        }else{
            if(minStack.peek()>=i)
            {
                minStack.push(i);
            }
            dataStack.push(i);
        }
    }

    void pop()
    {
        if(minStack.isEmpty() || dataStack.isEmpty())
        {
            return;
        }

        if(dataStack.peek()>minStack.peek())
        {
            dataStack.pop();
        }else{
            dataStack.pop();
            minStack.pop();
        }
    }

    Integer min()
    {
        if(minStack.isEmpty())
        {
            return null;
        }else{
            return minStack.pop();
        }
    }
}
