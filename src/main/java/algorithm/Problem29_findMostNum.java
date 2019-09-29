package algorithm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wqc on 2017/8/13.
 * 找出数组中出现次数最多的那个数
 * 使用HashMap，每个Entry的key存放数组中的数字，value存放该数字出现的次数，
 * 首先遍历数组元素构造HashMap，然后遍历每个Entry，找出最大value对应的key，即是出现次数最多的那个数。此算法的时间复杂度为O(n)。
 */
public class Problem29_findMostNum {

    public void findMostNum(int [] nums)
    {
        HashMap<Integer,Integer> contion = new HashMap<Integer,Integer>();
        for (int num : nums)
        {
            if(contion.containsKey(num))
            {
                Integer i = contion.get(num);
                contion.put(num,i+1);
            }else{
                contion.put(num,1);
            }
        }

        Integer maxCount = Collections.max(contion.keySet());
        for (Map.Entry<Integer, Integer> entry : contion.entrySet()) {
            if(entry.getValue() == maxCount)
            {
                System.out.println(entry.getKey());
            }
        }

    }
}
