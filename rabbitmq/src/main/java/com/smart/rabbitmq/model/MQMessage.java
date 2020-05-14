package com.smart.rabbitmq.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @version V1.0
 * @title: MQMessage
 * @description: 消息队列数据
 * @author: lukewei
 * @date: 2020/2/14 11:34
 * @remark: 修改内容
 */
@TableName("blc_mq_message")
public class MQMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "ID", type = IdType.INPUT)
    private Long id;
    /**
     * 消息内容
     */
    private String mqMessage;
    /**
     * 消息队列交换机
     */
    private String mqExchangeName;

    /**
     * 消息队列绑定的路由key
     */
    private String routingKey;
    /**
     * 消息队列名称
     */
    private String mqQueueName;
    /**
     * 消息发送次数
     */
    private Integer mqSendCount;
    /**
     * 发送状态：0开始发送，1发送成功，2发送失败
     */
    private Character mqSendStatus;
    /**
     * 下次尝试发送时间
     */
    private Date mqNextRetry;
    /**
     * 数据创建时间
     */
    private Date dateCreated;
    /**
     * 数据更新时间
     */
    private Date dateUpdated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMqMessage() {
        return mqMessage;
    }

    public void setMqMessage(String mqMessage) {
        this.mqMessage = mqMessage;
    }

    public String getMqExchangeName() {
        return mqExchangeName;
    }

    public void setMqExchangeName(String mqExchangeName) {
        this.mqExchangeName = mqExchangeName;
    }

    public String getMqQueueName() {
        return mqQueueName;
    }

    public void setMqQueueName(String mqQueueName) {
        this.mqQueueName = mqQueueName;
    }

    public Integer getMqSendCount() {
        return mqSendCount;
    }

    public void setMqSendCount(Integer mqSendCount) {
        this.mqSendCount = mqSendCount;
    }

    public Character getMqSendStatus() {
        return mqSendStatus;
    }

    public void setMqSendStatus(Character mqSendStatus) {
        this.mqSendStatus = mqSendStatus;
    }

    public Date getMqNextRetry() {
        return mqNextRetry;
    }

    public void setMqNextRetry(Date mqNextRetry) {
        this.mqNextRetry = mqNextRetry;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    @Override
    public String toString() {
        return "MQMessage{" +
            "id=" + id +
            ", mqMessage='" + mqMessage + '\'' +
            ", mqExchangeName='" + mqExchangeName + '\'' +
            ", routingKey='" + routingKey + '\'' +
            ", mqQueueName='" + mqQueueName + '\'' +
            ", mqSendCount=" + mqSendCount +
            ", mqSendStatus=" + mqSendStatus +
            ", mqNextRetry=" + mqNextRetry +
            ", dateCreated=" + dateCreated +
            ", dateUpdated=" + dateUpdated +
            '}';
    }

}
