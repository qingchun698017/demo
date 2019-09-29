package algorithm;

/**
 * Created by wqc on 2017/7/18.
 * 查找旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，称为数组的旋转
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素
 * 如：3,4,5,1,2  为1,2,3,4,5的一个旋转，最小值为1
 *
 *
 *算法步骤：1.和二分查找一样，我们用两个指针分别指向数组的第一个元素和最后一个元素。
 * 按照题目中旋转的规则，第一个元素应该大于或者等于最后一个元素。
 2.找到数组中间的元素。IF（中间元素大于或者等于第一个指针指向的元素）
 中间元素位于前面的递增子数组，数组中最小元素应该在该元素后面。
 我们可以把第一个指针指向该中间元素。查询范围缩小，
 第一个指针仍然在前面的递增子数组中。
 ELSE（中间元素小于或者等于第二个指针指向的元素）
 此时该数组中最小的元素应该位于该中间元素的前面，把第二个指针指向中间元素。
 缩小范围。 移动之后的第二个指针仍位于后面的  递增数组中。
 3.不管移动第一个指针还是第二个指针，查找范围都会缩小到原来的一半。更新指针做新一轮查找。
 4.按照上面的步骤，第一个指针总是指向前面的递增子数组，第二个指针总是指向后面的递归子数组。
 最终第一个指针指向前面的递增子数组的最后一个元素，第二个指针指向后面的递归子数组的第一个元素。
 他们最终会指向两个相邻的元素，儿第二个指针指向的刚好是最小的元素。这就是循环结束的条件。
 * 当两个指针指向的数字以及中间的数字三者相同时，
 * 我们无法判断中间的数字是位于前面的数组还是后面的数组，
 * 就无法通过移动两个指针来缩小查找范围。
 此时，应该采用顺序查找的方法。
 */
public class Problem8_findMinNumber {
    public Integer findMinNum(int[] array)
    {
        if(array == null)
        {
            return null;
        }

        int leftIndex = 0;
        int rightIndex =array.length-1;
        int mid = 0;
        while(array[leftIndex]>=array[rightIndex])
        {
            if(rightIndex-leftIndex <= 1)
            {
                mid = rightIndex;
                break;
            }

            mid = (leftIndex + rightIndex)/2;
            if(array[leftIndex] == array[rightIndex] && array[leftIndex] == array[mid])
            {
                return takeorder(array,leftIndex,rightIndex);
            }else if(array[mid] >= array[leftIndex]){

                leftIndex = mid;
            }else if(array[mid] <= array[rightIndex]){

                rightIndex = mid;
            }
        }
        return array[mid];
    }

    //旋转数组中最小的数字
    int takeorder(int[] array,int start,int end)
    {
        int min=array[start];
        for(int i=start;i<=end;i++)
        {

            if(array[i]<min)
                min=array[i];
        }
        return min;
    }

}
