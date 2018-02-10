package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by wqc on 2017/8/13.
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * Java中的TreeSet类实现了红黑树的功能，它底层是通过TreeMap实现的，
 * TreeSet中的数据会按照插入数据自动升序排列（按自然顺序）。因此我们直接将数据依次放入到TreeSet中，数组就会自动排序。
 */
public class Problem30_findMinKnum {
    public List findMinK(int[] nums, int k)
    {
        ArrayList<Integer> list = new ArrayList<Integer>(k);
        TreeSet<Integer> contions = new TreeSet<Integer>();
        for(int i = 0;i<nums.length;i++)
        {
            contions.add(nums[i]);
        }

        int i = 0 ;
        for (Integer contion : contions) {
            if(k>= i)
                break;
            list.add(contion);
            i++;
        }
        return list;
    }
}
