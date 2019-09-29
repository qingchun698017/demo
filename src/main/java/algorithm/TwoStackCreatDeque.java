package algorithm;

import java.util.Stack;

/**
 * Created by wqc on 2017/7/17.
 * 用两个栈实现队列：先进先出
 * 实现队列的两个方法appendTail和deleteHead,分别完成在队列尾插入节点和在队列头部删除节点的功能

 */
public class TwoStackCreatDeque<T> {
    //栈 先进后出
    private Stack<T> stackOne = new Stack<T>();
    private Stack<T> stackTwo = new Stack<T>();

    public void appendTail(T t)
    {
        stackOne.push(t);
    }

    public T deleteHead() throws Exception
    {
        if(stackTwo.isEmpty())
        {
            while(!stackOne.isEmpty())
            {
                stackTwo.push(stackOne.pop());
            }
        }

        if(stackTwo.isEmpty())
        {
            throw new Exception("队列为空，不能删除");
        }
        return stackTwo.pop();
    }
}
