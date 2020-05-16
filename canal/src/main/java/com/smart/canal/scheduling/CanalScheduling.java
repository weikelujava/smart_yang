package com.smart.canal.scheduling;

import com.alibaba.fastjson.JSON;
import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import com.alibaba.otter.canal.protocol.exception.CanalClientException;
import com.smart.canal.bean.BlcCategory;
import com.smart.canal.repository.BlcCategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @version V1.0
 * @title: CanalScheduling
 * @description:
 * @author: lukewei
 * @date: 2020/5/16 12:33
 * @remark: 修改内容
 */
@Slf4j
@Component
public class CanalScheduling implements Runnable, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Autowired
    private CanalConnector canalConnector;

    @Autowired
    private BlcCategoryRepository blcCategoryRepository;


    @Scheduled(fixedDelay = 100)
    @Override
    public void run() {
        //获取指定数量的数据
        int batchSize = 1000;

        try {
            Message message = canalConnector.getWithoutAck(batchSize);
            long batchId = message.getId();
            int size = message.getEntries().size();
            try {
                if(batchId != -1 && size > 0){
                    for (CanalEntry.Entry entry : message.getEntries()) {
                        if(entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONBEGIN || entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONEND){
                            continue;
                        }
                        publishCanalEvent(entry);
                    }
                }
                canalConnector.ack(batchId);
            }catch (Exception e){
                log.info("Send listen event failed! BatchId rollback,batchId=" + batchId,e);
                canalConnector.rollback();
            }
        } catch (CanalClientException e) {
            log.error("Canal_scheduled Exception!",e);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 事件处理器
     *
     * @param entry
     */
    private void publishCanalEvent(CanalEntry.Entry entry) {
        CanalEntry.EventType eventType = entry.getHeader().getEventType();
        String schemaName = entry.getHeader().getSchemaName();
        String tableName = entry.getHeader().getTableName();

        log.debug("正在处理，内容为：" + eventType.toString() + "--" + schemaName + "--" + tableName + "");
        switch (eventType) {
            case INSERT:
//                applicationContext.publishEvent(new InsertCanalEvent(entry));
                handleInertEntry(entry);
                break;
            case UPDATE:
                handleUpdateEntry(entry);
                break;
            case DELETE:
                handleDeleteEntry(entry);
                break;
            default:
                break;
        }
    }

    /**
     * 处理表插入事件
     * @param entry
     */
    private void handleInertEntry(CanalEntry.Entry entry) {
        CanalEntry.RowChange rowChange;
        try {
            rowChange = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
        } catch (Exception e) {
            throw new RuntimeException("ERROR ## parser of eromanga-event has an error , data:" + entry.toString(), e);
        }

        String tableName = entry.getHeader().getTableName();
        for (CanalEntry.RowData rowData : rowChange.getRowDatasList()) {
            Map<String, Object> columnsMap = getColumnsMap(rowData.getAfterColumnsList());
            switch (tableName) {
                // 公园分类表
                case "blc_category":
                    long categoryId = Long.parseLong(String.valueOf(columnsMap.get("CATEGORY_ID")));
                    BlcCategory category = JSON.parseObject(JSON.toJSONString(columnsMap), BlcCategory.class);
                    category.setId(categoryId);
                    blcCategoryRepository.save(category);
                    break;

                default:
                    break;
            }
        }
    }

    /**
     * 处理表更新事件
     * @param entry
     */
    private void handleUpdateEntry(CanalEntry.Entry entry) {
        CanalEntry.RowChange rowChange;
        try {
            rowChange = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
        } catch (Exception e) {
            throw new RuntimeException("ERROR ## parser of eromanga-event has an error , data:" + entry.toString(), e);
        }

        String tableName = entry.getHeader().getTableName();
        for (CanalEntry.RowData rowData : rowChange.getRowDatasList()) {
            Map<String, Object> columnsMap = getColumnsMap(rowData.getAfterColumnsList());
            switch (tableName) {
                case "blc_category":
                    // binlog读取修改后的数据，并对数据转换成es对象存储更新
                    long categoryId = Long.parseLong(String.valueOf(columnsMap.get("CATEGORY_ID")));
                    blcCategoryRepository.deleteById(categoryId);
                    BlcCategory category = JSON.parseObject(JSON.toJSONString(columnsMap), BlcCategory.class);
                    // 对es中对象id和db中的主键进行关联映射
                    category.setId(categoryId);
                    blcCategoryRepository.save(category);
                    break;
                default:
                    break;

            }
        }
    }


    /**
     * 处理表删除事件
     * @param entry
     */
    private void handleDeleteEntry(CanalEntry.Entry entry) {
        CanalEntry.RowChange rowChange;
        try {
            rowChange = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
        } catch (Exception e) {
            throw new RuntimeException("ERROR ## parser of eromanga-event has an error , data:" + entry.toString(), e);
        }

        String tableName = entry.getHeader().getTableName();
        for (CanalEntry.RowData rowData : rowChange.getRowDatasList()) {
            Map<String, Object> columnsMap = getColumnsMap(rowData.getBeforeColumnsList());
            switch (tableName) {
                case "blc_category":
                    blcCategoryRepository.deleteById(Long.parseLong(String.valueOf(columnsMap.get("CATEGORY_ID"))));
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 获取Map
     *
     * @param columns
     * @return
     */
    private Map<String, Object> getColumnsMap(List<CanalEntry.Column> columns) {
        Map<String, Object> jsonMap = new HashMap<>();
        columns.forEach(column -> {
            if (column == null) {
                return;
            }
            jsonMap.put(column.getName(), column.getValue());
        });
        return jsonMap;
    }
}
