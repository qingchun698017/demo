package offer;

import java.util.HashMap;

/**
 * Created by wqc on 2017/8/12.
 * 给定一个整型的数组，找出其中的两个数使其和未指定的值，
 * 返回两个数的数组下标（假定是无序数组，数组元素各不相同，
 * 要求时间复杂度为O(n),n为数组长度,可以使用辅助空间）

 分析：时间复杂度是O(n)，即是扫描一遍数组，不可嵌套扫描。
 必须全部数组扫描和查找全部，扫描+查找=O(n)，
 可以使用数据结构哈希表，哈希表的查找的时间复杂度是O(1)。
 */
public class Problem41_findTwo {

    public void findTwo(int[] nums,int sum)
    {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i=0;i<nums.length;i++)
        {
            map.put(nums[i],i);
        }

        for(int i = 0; i<nums.length;i++)
        {
            int two = sum - nums[i];
            if(map.containsKey(two) && sum != 2*two)
            {
                System.out.println(i+"   "+map.get(two));
            }
        }
    }

}
