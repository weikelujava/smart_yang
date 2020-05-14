package com.smart.rabbitmq.common;

import java.io.Serializable;
import java.util.List;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: CommonEntity
 * @description:
 * @author: lukewei
 * @date: 2020/4/23 17:19
 * @remark: 修改内容
 */
public class CommonEntity implements Serializable {

    private static final long serialVersionUID = -1447849093369640977L;

    /**
     * 对象的集合缓存的键值,用于删除受影响的缓存
     */
    private List<String> listCacheKey;

    /**
     * 对象单个缓存的键值
     */
    private String cacheKey;

    /**
     * 缓存对象
     */
    private Object object;

    /**
     * 数据库中对象版本号
     */
    private Integer dbEntityVersion;

    /**
     * redis中对象版本号
     */
    private Integer redisEntityVersion;

    /**
     * 交换机名称
     */
    private String exchangeName;

    /**
     * 队列名称
     */
    private String queueName;

    /**
     * 全局唯一ID
     */
    private Long messageId;

    public CommonEntity() {
    }

    public List<String> getListCacheKey() {
        return listCacheKey;
    }

    public void setListCacheKey(List<String> listCacheKey) {
        this.listCacheKey = listCacheKey;
    }

    public String getCacheKey() {
        return cacheKey;
    }

    public void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Integer getDbEntityVersion() {
        return dbEntityVersion;
    }

    public void setDbEntityVersion(Integer dbEntityVersion) {
        this.dbEntityVersion = dbEntityVersion;
    }

    public Integer getRedisEntityVersion() {
        return redisEntityVersion;
    }

    public void setRedisEntityVersion(Integer redisEntityVersion) {
        this.redisEntityVersion = redisEntityVersion;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return "CommonEntity{" +
            "listCacheKey=" + listCacheKey +
            ", cacheKey='" + cacheKey + '\'' +
            ", object=" + object +
            ", dbEntityVersion=" + dbEntityVersion +
            ", redisEntityVersion=" + redisEntityVersion +
            ", exchangeName='" + exchangeName + '\'' +
            ", queueName='" + queueName + '\'' +
            ", messageId=" + messageId +
            '}';
    }
}
