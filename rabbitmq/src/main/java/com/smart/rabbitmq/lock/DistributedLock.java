/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0.0
 * @title:
 * @description:
 * @author: hollysmart
 * @date: 2019/10/16 12:31
 * @remark:
 */

package com.smart.rabbitmq.lock;

/**
 * 分布式锁顶级接口
 * 例如：
 * RETRY_TIMES=100，SLEEP_MILLIS=100
 * RETRY_TIMES * SLEEP_MILLIS = 10000 意味着如果一直获取不了锁，最长会等待10秒后抛超时异常
 *
 * @author lukewei
 * @date 2020年5月14日13:34:33
 */
public interface DistributedLock {

    /**
     * 默认超时时间
     */
    long TIMEOUT_MILLIS = 5000;

    /**
     * 重试次数
     */
    int RETRY_TIMES = 100;

    /**
     * 每次重试后等待的时间
     */
    long SLEEP_MILLIS = 100;

    /**
     * 获取锁
     *
     * @param key key
     * @return 成功/失败
     */
    boolean lock(String key);

    /**
     * 获取锁
     *
     * @param key        key
     * @param retryTimes 重试次数
     * @return 成功/失败
     */
    boolean lock(String key, int retryTimes);

    /**
     * 获取锁
     *
     * @param key         key
     * @param retryTimes  重试次数
     * @param sleepMillis 获取锁失败的重试间隔
     * @return 成功/失败
     */
    boolean lock(String key, int retryTimes, long sleepMillis);

    /**
     * 获取锁
     *
     * @param key    key
     * @param expire 获取锁超时时间
     * @return 成功/失败
     */
    boolean lock(String key, long expire);

    /**
     * 获取锁
     *
     * @param key        key
     * @param expire     获取锁超时时间
     * @param retryTimes 重试次数
     * @return 成功/失败
     */
    boolean lock(String key, long expire, int retryTimes);

    /**
     * 获取锁
     *
     * @param key         key
     * @param expire      获取锁超时时间
     * @param retryTimes  重试次数
     * @param sleepMillis 获取锁失败的重试间隔
     * @return 成功/失败
     */
    boolean lock(String key, long expire, int retryTimes, long sleepMillis);

    /**
     * 释放锁
     *
     * @param key key值
     * @return 释放结果
     */
    boolean releaseLock(String key);
}
