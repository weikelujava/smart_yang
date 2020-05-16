package com.smart.canal.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: ElasticsearchConfig
 * @description:
 * @author: lukewei
 * @date: 2020/5/16 14:51
 * @remark: 修改内容
 */
@Configuration
@ConfigurationProperties(prefix = "es")
public class EsConfig {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
