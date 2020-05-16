package com.smart.canal.clinet;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.smart.canal.config.CanalConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 *
 * @version V1.0
 * @title: CanalClient
 * @description:
 * @author: lukewei
 * @date: 2020/5/16 11:50
 * @remark: 修改内容
 */

@Component
@Slf4j
public class CanalClient implements DisposableBean {

    private CanalConnector canalConnector;

    @Autowired
    private CanalConfig canalConfig;

    @Bean
    public CanalConnector getCanalConnector(){
        if(canalConfig == null){
            throw new RuntimeException("Error, CanalConfig is null");
        }
        // 创建链接
        canalConnector = CanalConnectors.newClusterConnector(
                canalConfig.getIp(),
                canalConfig.getDestination(),
                "",
                ""
        );
        // 开始链接
        canalConnector.connect();
        // 指定filter.格式化{database}.{table}。这里不做过滤，过滤操作留给用户在canal中配置
        canalConnector.subscribe(".*");
        canalConnector.rollback();
        log.info("Canal client start-up success");
        return canalConnector;
    }

    /**
     * Bean销毁时断开Canal的链接
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        if(null != canalConnector){
            canalConnector.disconnect();
        }
    }
}
