/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package sort;

import java.util.Arrays;

/**
 * TODO
 *
 * @author wqc
 * @version V1.0
 * @since 2019-08-18 21:48
 */
public class Sort {


        /**
        * 插入排序
        *
        * 1. 从第一个元素开始，该元素可以认为已经被排序
        * 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
         * 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
        * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
        * 5. 将新元素插入到该位置后
        * 6. 重复步骤2~5
        * @param arr  待排序数组
        */
    public static void insertionSort1(int[] arr){
        for( int i = 1; i < arr.length; i++ ) {
            int temp = arr[i];    // 取出下一个元素，在已经排序的元素序列中从后向前扫描
            for( int j = i; j >= 0; j-- ) {
                if( j > 0 && arr[j-1] > temp ) {
                    arr[j] = arr[j-1];    // 如果该元素（已排序）大于取出的元素temp，将该元素移到下一位置
                    System.out.println("Temping:  " + Arrays.toString(arr));
                } else {
                    // 将新元素插入到该位置后
                    arr[j] = temp;
                    System.out.println("Sorting:  " + Arrays.toString(arr));
                    break;
                 }
            }
        }
    }

    // 交换次数较多的实现
    public static void insertionSort2(int[] arr){
        for( int i=0; i<arr.length-1; i++ ) {
            for( int j=i+1; j>0; j-- ) {
                if( arr[j-1] <= arr[j] )
                    break;
                int temp = arr[j];      //交换操作
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                System.out.println("Sorting:  " + Arrays.toString(arr));
            }
        }
    }

}
