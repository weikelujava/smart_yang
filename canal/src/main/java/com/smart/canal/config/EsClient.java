package com.smart.canal.config;

import org.apache.http.client.config.RequestConfig;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;

import java.time.Duration;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: EsConf
 * @description:
 * @author: lukewei
 * @date: 2020/5/16 13:06
 * @remark: 修改内容
 */

@Configuration
public class EsClient {

    @Autowired
    private EsConfig esConfig;



    /**
     * Elasticsearch官方推荐使用该方式创建客户端连接
     * connectedTo()：连接的Elasticsearch的地址和端口
     * withConnectTimeout：连接超时时间
     *
     * @return
     */
    @Bean
    RestHighLevelClient elasticsearchClient(){


        ClientConfiguration configuration = ClientConfiguration.builder()
                .connectedTo(esConfig.getUrl())
                .withConnectTimeout(5000)
                .withSocketTimeout(40000)
//                .withBasicAuth("username","password")
                .build();
        return RestClients.create(configuration).rest();
    }
}
