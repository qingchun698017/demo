/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package redis;

import java.util.UUID;

import redis.clients.jedis.Jedis;

/**
 * TODO
 *
 * @author wqc
 * @version V1.0
 * @since 2019-06-18 11:10
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        testLock();
    }

    private static void testLock() throws InterruptedException {
        for (int i= 0;i<100;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        runLock();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }

    }

    private static void runLock() throws InterruptedException {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        RedisLock redisLock = new RedisLock(jedis);
        String key = "key";
        String request = UUID.randomUUID().toString();
        boolean locktest = false;
        try {
            locktest = redisLock.tryLock(key, request,5);
            if (locktest) {
                System.out.println(Thread.currentThread().getName()+"获锁成功 执行----------------------get rock success-----------");
                Thread.sleep(4000);
            }
        } finally {
            if(locktest){
                redisLock.releaseLock(key,request) ;
            }

        }
    }

}
