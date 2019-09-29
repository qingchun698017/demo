package algorithm;

import java.util.Stack;

/**
 * Created by wqc on 2017/7/29.
 * 输入一棵二叉树和一个整数,打印出二叉树中结点值的和为输入整数的所有路径.
 * 从树的根结点开始往下一直到叶结点所经过的结点形成一条路径.
 */
public class Problem25_findPath {
    public void findPath(int sum,BinaryTreeNode node)
    {
        if(node == null)
        {
            return;
        }

        int countSum = 0;
        Stack stack = new Stack();
        findPath(sum,stack,node,countSum);
    }

    public void findPath(int sum, Stack stack,BinaryTreeNode node,int countSum)
    {
        countSum +=node.data;
        stack.push(node.data);
        if(node.rightNode == null && node.leftNode ==null)
        {
            if(countSum == sum)
            {
                System.out.println("find Path:");
                for (Object i : stack) {
                    System.out.println(" "+ (int)i);
                }

            }
        }

        if(node.leftNode != null)
        {
            findPath(sum, stack, node.leftNode,countSum);
        }
        if(node.rightNode != null)
        {
            findPath(sum, stack, node.rightNode,countSum);
        }

        stack.pop();

    }
}
