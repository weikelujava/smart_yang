package com.smart.rabbitmq.service.impl;

//import com.smart.rabbitmq.feign.LeafService;
import com.smart.rabbitmq.mapper.MQMessageMapper;
import com.smart.rabbitmq.model.MQMessage;
import com.smart.rabbitmq.service.IMQMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: MQMessageServiceImpl
 * @description:
 * @author: lukewei
 * @date: 2020/4/9 14:55:33
 * @remark: 修改内容
 */
@Slf4j
@Service
@Transactional(readOnly = true)
public class MQMessageServiceImpl extends SuperServiceImpl<MQMessageMapper, MQMessage> implements IMQMessageService {

//    @Autowired
//    private LeafService leafService;


    @Override
    @Transactional(readOnly = false)
    public boolean updateStatus(Long messageId, Character status, Date dateUpdated) {
        return baseMapper.updateStatus(messageId, status, dateUpdated) > 0;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean saveMqMessage(MQMessage mqMessage) {
        //雪花算法生成唯一ID
//        ResultEntity entity = leafService.generateIdBySnowFlake();
//        mqMessage.setId(entity.getId());
        Long id = System.currentTimeMillis()+UUID.randomUUID().hashCode();
        mqMessage.setId(id);
        return baseMapper.saveMqMessage(mqMessage) > 0;
    }

    @Override
    public List<MQMessage> findMqMessageFailedList() {
        return baseMapper.findMqMessageFailedList();
    }

    @Override
    public Integer findMqMessageSuccessCountByMessageId(Long messageId) {
        return baseMapper.findMqMessageSuccessCountByMessageId(messageId);
    }
}
