/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package jdk8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 组合异步编程
 *
 * @author wqc
 * @version V1.0
 * @since 2019-07-08 22:07
 */
public class CompletableFutureExample {

    public static void main(String[] args) {
        System.out.println("main-Thread1:"+Thread.currentThread().getName());

        /**
         * 请求量不大的情况 理论只要达到CPU核数(Runtime.getRuntime().availableProcessors())就可以
         */
        ExecutorService executorService =
            new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 2,
                Runtime.getRuntime().availableProcessors() * 2, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        System.out.println("当前活跃-Thread:"+((ThreadPoolExecutor) executorService).getActiveCount());

        //查询体检报告数量
        CompletableFuture<Long> physicalExamCount = CompletableFuture.supplyAsync(()->{
            //TODO
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("physicalExamCount-Thread:"+Thread.currentThread().getName());
            return 0L;
        },executorService).exceptionally(throwable -> {
            //打印错误信息
            return 0L;
        });

        //查询检查检验数量
        CompletableFuture<Long> labAndExamCount = CompletableFuture.supplyAsync(()->{
           //TODO
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("labAndExamCount-Thread:"+Thread.currentThread().getName());
            return 0L;
        },executorService).exceptionally(throwable -> {
            //打印错误信息
            return 0L;
        });

        //查询所有的元数据
        CompletableFuture<Object> metaInfo = CompletableFuture.supplyAsync(()->{
            //TODO
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("metaInfo-Thread:"+Thread.currentThread().getName());
            return null;
        },executorService).exceptionally(throwable -> {
            return null;
        });

        System.out.println("main-Thread2:"+Thread.currentThread().getName());

        //检查检验数量
        long lCount = 0;
        try {
            lCount = labAndExamCount.get(6,TimeUnit.SECONDS);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }


        //体检报告数量
        long pCount = 0;
        try {
            pCount = physicalExamCount.get(6,TimeUnit.SECONDS);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        //所有的元数据
        Object metaInfoObject;
        try {
            metaInfoObject = metaInfo.get(6,TimeUnit.SECONDS);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println("当前活跃-Thread:"+((ThreadPoolExecutor) executorService).getActiveCount());

    }
}
