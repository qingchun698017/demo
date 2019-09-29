/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package redis;

import java.util.Collections;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

/**
 * TODO
 *
 * @author wqc
 * @version V1.0
 * @since 2019-06-17 21:57
 */
@Component
@Slf4j
public class RedisLock {

    /**
     * 释放锁成功返回值
     */
    private static final Long RELEASE_SUCCESS = 1L;
    /**
     * 加锁成功返回值
     */
    private static final String LOCK_SUCCESS = "OK";


    /**
     * 用来表示 setnx 的参数
     */
    private static final String SET_IF_NOT_EXIST = "NX";
    /**
     * EX = seconds（秒）; PX = milliseconds（毫秒）
     */
    private static final String SET_WITH_EXPIRE_TIME = "EX";


    private Jedis jedis;

    public RedisLock(Jedis jedis) {
        this.jedis = jedis;
    }


    /**
     * 尝试获取分布式锁
     *
     * @param lockKey    锁
     * @param requestId 请求标识 用于防止其他用户解锁
     * @param expireTime 超期时间
     * @return 是否获取成功  true：成功获取锁；false：未获取锁资格
     */
    public boolean tryLock(String lockKey,String requestId, int expireTime) {
        log.info("努力获锁，用户：{}， 锁值为：{}，争取锁线程：{}",
            requestId, lockKey,Thread.currentThread().getName());

        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);

        if (LOCK_SUCCESS.equals(result)) {
            log.info("获取锁成功，获锁用户：{}， 锁值为：{}，获取锁线程：{}",
                requestId, lockKey,Thread.currentThread().getName());
            return true;
        }
        return false;
    }

    /**
     * 释放分布式锁
     *
     * @param lockKey   锁
     * @param requestId 请求标识 用于防止其他用户解锁
     * @return 是否释放成功  true：手动解锁成功；false：手动解锁失败
     */
    public boolean releaseLock(String lockKey,String requestId) {

        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey),  Collections.singletonList(requestId));
         if (RELEASE_SUCCESS.equals(result)) {
             log.info("释放锁成功，解锁用户：{}， 锁值为：{}，释放锁线程：{}",
                 requestId, lockKey,Thread.currentThread().getName());
            return true;
        }
        log.info("解锁失败，解锁用户：{}， 锁值为：{},释放锁线程：{}", requestId, lockKey,Thread.currentThread().getName());
        return false;
    }
}
