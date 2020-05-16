package com.smart.canal.event;

import com.alibaba.otter.canal.protocol.CanalEntry;
import org.springframework.context.ApplicationEvent;

/**
 *
 * @version V1.0
 * @title: CanalEvent
 * @description:
 * @author: lukewei
 * @date: 2020/5/16 12:20
 * @remark: 修改内容
 */
public abstract class CanalEvent extends ApplicationEvent {

    /**
     * 每个事件的资源定义
     * @param source
     */
    public CanalEvent(Object source) {
        super(source);
    }

    /**
     * 暴露获取对象事件方法
     * 第二监听器监听到事件后，需要获取时间对象资源进行处理
     * @return
     */
    public CanalEntry.Entry getEntry(){
        return (CanalEntry.Entry) source;
    }
}
