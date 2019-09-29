package algorithm;

/**
 * Created by wqc on 2017/8/13.
 * 一个整数数组中的元素有正有负，在该数组中找出一个连续子数组，要求该连续子数组中各元素的和最大，
 * 这个连续子数组便被称作最大连续子数组。
 * 比如数组{2,4,-7,5,2,-1,2,-4,3}的最大连续子数组为{5,2,-1,2}，最大连续子数组的和为5+2-1+2=8。
 * 最优方法，时间复杂度O（n）
 和最大的子序列的第一个元素肯定是正数
 因为元素有正有负，因此子序列的最大和一定大于0
 */
public class Problem31_findMaxSum {
    public int findMaxSum(int[] nums)
    {
        int curSum = 0;
        int maxSum = 0;
        for (int num : nums) {
            curSum=+num;
            if(curSum>maxSum)
            {
                maxSum = curSum;
            }

            //如果累加和出现小于0的情况，
            //则和最大的子序列肯定不可能包含前面的元素，
            //这时将累加和置0，从下个元素重新开始累加
            if(curSum<0)
            {
                curSum = 0;
            }
        }
        return maxSum;
    }
}
