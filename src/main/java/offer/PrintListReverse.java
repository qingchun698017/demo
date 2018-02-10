package offer;


import org.w3c.dom.Node;

import java.util.Stack;

/**
 * Created by wqc on 2017/7/17.
 * 输入一个链表的头结点，从尾到头反过来打印出每个节点的值
 *
 */
public class PrintListReverse {
    public static void main(String[] args) {
       // ListNode node1 = new ListNode(pre,next,data);
    }

    static class ListNode<K,V>
    {
        int data;
        ListNode pre;
        ListNode next;
        ListNode(ListNode pre,ListNode next,int data)
        {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }

    }

    public static void printListReverseOne(ListNode headNode)
    {
        //栈 先进后出
        Stack<ListNode> stack = new Stack<ListNode>();
        while(headNode != null)
        {
            stack.push(headNode);
            headNode = headNode.next;
        }

        while(!stack.isEmpty())
        {
            System.out.println(stack.pop().data);
        }
    }
    //递归
    public static void printListReverseTwo(ListNode headNode) {
        if(headNode != null)
        {
            if(headNode.next != null)
            {
                printListReverseTwo(headNode.next);
            }
        }

        System.out.println(headNode.data);
    }
}
