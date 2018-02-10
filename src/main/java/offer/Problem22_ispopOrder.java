package offer;

import java.util.Stack;

/**
 * Created by wqc on 2017/7/24.
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 *
 * 解决这个问题很直观的想法就是建立一个辅助栈，把输入的第一个序列中的数字依次压入该辅助栈，
 * 并按照第二个序列的顺序依次从该栈中弹出数字。
 * 判断一个序列是不是栈的弹出顺序的规律：如果下一个弹出的数字刚好是栈顶数字，那么直接弹出。
 * 如果下一个弹出的数字不在栈顶，我们把压栈序列中还没有入栈的数字压入辅助栈，知道把下一个需要弹出的数字压入栈顶为止。
 * 如果所有的数字都压入栈了仍没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列。
 */
public class Problem22_ispopOrder {
    boolean ispopOrder(int[] pPush,int[] pPop)
    {
        boolean result = false;
        if(pPop != null && pPush != null)
        {
            Stack<Integer>  stack = new Stack<Integer>();
            int i=0,j=0;
            //检查每个出栈
            while(j<pPop.length){
                while (i<pPush.length && pPop[j] != pPush[i])
                {
                    stack.push(pPush[i]);
                    i++;
                }
                //相等的元素没有入栈,相等的两个数组都跳过该值
                ++i;
                ++j;
                int top=0;
                //出栈比较
                while((!stack.isEmpty()) && (top = stack.pop()) == pPop[j])
                {
                    ++j;
                }
                if(j<pPop.length)
                {
                    stack.push(top);
                }
                //当已经找不到进栈元素时退出
                if(i > pPush.length && !stack.isEmpty())
                {
                    break;
                }

            }
            if(stack.isEmpty())
            {
                result = true;
            }

        }
        return result;
    }
}
