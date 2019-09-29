/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package OOM;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆OOM
 * jvm运行参数
 *  -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *  堆大小设置为20M，新生代10M，新生代中可用的是9M，剩余1M用来垃圾收集器回收的交换区
 * @author wqc
 * @version V1.0
 * @since 2019-06-17 18:00
 */
public class HeapOOM {
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
