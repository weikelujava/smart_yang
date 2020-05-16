package com.smart.canal.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @version V1.0
 * @title: CanalConfig
 * @description:
 * @author: lukewei
 * @date: 2020/5/16 12:03
 * @remark: 修改内容
 */
@Component
@ConfigurationProperties(prefix = "canal")
public class CanalConfig {

    /**
     * Ip
     */
    private String ip;

    /**
     * port
     */
    private int port;

    /**
     * 实例名称
     */
    private String destination;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    public CanalConfig() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
