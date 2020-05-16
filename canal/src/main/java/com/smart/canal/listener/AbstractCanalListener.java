package com.smart.canal.listener;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.google.protobuf.InvalidProtocolBufferException;
import com.smart.canal.event.CanalEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

/**
 *
 * @version V1.0
 * @title: CanalListener
 * @description:
 * @author: lukewei
 * @date: 2020/5/16 12:18
 * @remark: 修改内容
 */
@Slf4j
public abstract class AbstractCanalListener<E extends CanalEvent> implements ApplicationListener<E> {

    @Override
    public void onApplicationEvent(E event) {
        CanalEntry.Entry entry = event.getEntry();
        String database = entry.getHeader().getSchemaName();
        String table = entry.getHeader().getTableName();
        CanalEntry.RowChange change = null;
        try {
            change = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
        } catch (InvalidProtocolBufferException e) {
            log.error("Get RowChange by CanalEntry failed");
            e.printStackTrace();
        }
        if (null != change) {
            change.getRowDatasList().forEach(rowData -> doSync(database, table, rowData));
        }
    }

    /**
     * 可以根据不同的操作来实现该方法
     * @param database 数据库
     * @param table    表
     * @param rowData  行数据
     */
    protected abstract void doSync(String database, String table, CanalEntry.RowData rowData);

}
