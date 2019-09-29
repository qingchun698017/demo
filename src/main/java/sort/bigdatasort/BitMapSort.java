/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package sort.bigdatasort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.BitSet;

import sun.security.util.BitArray;

/**
 * 位图排序 10亿
 * 文件中保存了10亿条数据，数据类型为整数，取值范围[1, 1000000]，现需要对这10亿条数据进行排
 * @author wqc
 * @version V1.0
 * @since 2019-08-21 17:12
 */
public class BitMapSort {


    public static void main(String[] args) throws IOException {
        //sortArrayBitSet();
        sortArrayBitArray();
    }

    public static void sortArrayBitSet() throws IOException {

        BitSet bitSet = new BitSet();
        BufferedReader br = new BufferedReader(new FileReader("D://demoDate//bigData.txt"));
        String text= null;
        while((text = br.readLine()) != null) {
            bitSet.set(Integer.parseInt(text));

        }
        //剔除重复数字后的元素个数
        int bitLen=bitSet.cardinality();
        System.out.println("iterate over the true bits in a BitSet--:"+bitLen);
        BufferedWriter writer = new BufferedWriter(new FileWriter("D://demoDate//bigDataSort.txt"));
        //或直接迭代BitSet中bit为true的元素iterate over the true bits in a BitSet
        for (int i = bitSet.nextSetBit(0); i >= 0; i = bitSet.nextSetBit(i + 1)) {
            writer.write(String.valueOf(i)
                + System.getProperty("line.separator"));///n
            System.out.print(i+"\t");
        }
        writer.close();
        System.out.println("---------------------------");
    }

    public static void sortArrayBitArray() throws IOException {

        BitArray bitArray = new BitArray(1000000);
        BufferedReader br = new BufferedReader(new FileReader("D://demoDate//bigData.txt"));
        String text= null;
        while((text = br.readLine()) != null) {
            bitArray.set(Integer.parseInt(text),true);

        }
        //剔除重复数字后的元素个数
        int bitLen=bitArray.length();
        System.out.println("iterate over the true bits in a BitSet--:"+bitLen);
        BufferedWriter writer = new BufferedWriter(new FileWriter("D://demoDate//bigDataSort.txt"));
        //或直接迭代BitSet中bit为true的元素iterate over the true bits in a BitSet
        for (int i = 0; i <bitLen; i ++) {
            if(bitArray.get(i)){
                writer.write(String.valueOf(i)
                    + System.getProperty("line.separator"));///n
                System.out.print(i+"\t");
            }

        }
        writer.close();
        System.out.println("---------------------------");
    }

}
