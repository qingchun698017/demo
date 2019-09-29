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
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

/**
 * 归并排序
 *
 * @author wqc
 * @version V1.0
 * @since 2019-08-21 17:11
 */
public class MergeSort {

    /**
     * 1、拆分文件 小文件排序
     * 2、归并算法 合并小文件
     * @param args
     */
    public static void main(String[] args) {
        try {
            splitData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //读文件
        String[] files = getFiles();
        try {
            multiWaysMergeSort(files);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] getFiles() {
        //todo
        return null;
    }

    /**
     * 将原始数据分成几块 并排序 再保存到临时文件
     * @throws IOException
     */
    public static void splitData() throws IOException {
        String originalPath="D://demoDate//bigData.txt";
        String tempFilePath="D://demoDate//";
        int bigDataLength = 1000000000;
        int tempFileLength = 1000000;
        @SuppressWarnings("resource")
        BufferedReader br = new BufferedReader(new FileReader(originalPath));
        File[] tempFiles = new File[bigDataLength / tempFileLength];
        for (int i = 0; i < tempFiles.length; i++) {
            tempFiles[i] = new File(tempFilePath + "TempFile" + i + ".txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFiles[i]));
            TreeMap map = new TreeMap();
            for (int j = 1; j <= tempFileLength; j++) {
                String text = null;
                if ((text = br.readLine()) != null) {
                    map.put(j, text);
                }
            }

            //排序完写入小文件
            for(int k=1; k<=tempFileLength; k++){
                writer.write(String.valueOf(map.get(k))
                    + System.getProperty("line.separator"));
            }
            writer.close();
        }

    }


    /**
     * 归并排序
     * @param files
     * @throws IOException
     */
    public static void multiWaysMergeSort(String[] files) throws IOException {
        String tempFilePath="D://demoDate//tempData_";
        for (int i = 0; i < files.length; i+=2) {
            //将br1 和 br2 写入到Write
            BufferedReader br1 = new BufferedReader(new FileReader(files[i]));
            BufferedReader br2 = new BufferedReader(new FileReader(files[i + 1]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFilePath + "last_" + i + ".txt"));
            String s1 = br1.readLine();
            String s2 = br2.readLine();
            while (s1 != null || s2 != null) {
                if (s1 != null && s2 != null) {
                    //都不为空 才有比较的必要
                    int mergeResult = s1.compareTo(s2);
                    if (mergeResult > 0) {//s1在s2后面
                        writer.write(s2);
                        writer.write(System.getProperty("line.separator"));
                        s2 = br2.readLine();
                    }
                    if (mergeResult == 0) {//s1=s2
                        writer.write(s1);
                        writer.write(System.getProperty("line.separator"));
                        writer.write(s2);
                        writer.write(System.getProperty("line.separator"));
                        //System.out.println("write time : " + writeTime++);
                        s1 = br1.readLine();
                        s2 = br2.readLine();
                    }
                    if (mergeResult < 0) {//s1在s2前面
                        writer.write(s1);
                        writer.write(System.getProperty("line.separator"));
                        s1 = br1.readLine();
                    }
                }
                if (s1 == null && s2 != null) {
                    writer.write(s2);
                    writer.write(System.getProperty("line.separator"));
                    s2 = br2.readLine();
                }
                if (s2 == null && s1 != null) {
                    writer.write(s1);
                    writer.write(System.getProperty("line.separator"));
                    s1 = br1.readLine();
                }
            }
            br1.close();
            br2.close();
            writer.close();
        }

        multiWaysMergeSort(getFiles());
    }
}
