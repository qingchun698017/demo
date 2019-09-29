/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package sort.bigdatasort;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * TODO
 *
 * @author wqc
 * @version V1.0
 * @since 2019-08-21 18:09
 */
public class CreateTestData {

    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("D://demoDate//bigData.txt"));
        Random random = new Random();

        int length = 1;
        for (int i = 0; i < 1000000; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < length; j++) {
                sb.append(random.nextInt(1000000));
            }
            System.out.println("sb---->"+sb);
            writer.write(sb.toString() + "\n");
        }
        writer.close();
    }

}
