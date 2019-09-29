package algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by wqc on 2017/8/13.
 * 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323
 *
 * 把数字m和n拼接起来得到mn和nm，他们的位数一定是相同的，
 * 因此比较他们的大小只需要按照字符串大小的比较规则就可以了
 */
public class Problem33_printMinSum {
    public void printMinSum(int[] nums)
    {
        if(nums == null || nums.length == 0)
        {
            return;
        }
        int len = nums.length;
        String[] strArr = new String[len];
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<len;i++) {
            strArr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String c1=o1+o2;
                String c2=o2+o1;
                return c1.compareTo(c2);
            }
        });

        for(int i=0;i<len;i++)
        {
            sb.append(strArr[i]);
        }
        System.out.println(sb.toString());
    }
}
