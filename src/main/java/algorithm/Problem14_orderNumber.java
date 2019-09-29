package algorithm;

/**
 * Created by wqc on 2017/7/22.
 * 输入一个整数数组，实现一个排序方法，使得数组里所有的偶数在前，所有的奇数在后
 *
 */
public class Problem14_orderNumber {
    public void order(int[] array)
    {
        int start = 0;
        int end = array.length-1;
        while(start < end)
        {
            while(start < end && isEven(array[start]))
            {
                start++;
            }
            while(start < end && !isEven(array[end]))
            {
                end--;
            }

            if(start < end)
            {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }

        }
    }

    boolean isEven(int n)
    {
        return n%2 == 0;
    }
}
