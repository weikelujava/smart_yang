package com.smart.rabbitmq.constant;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0.0
 * @title: ServiceNameConstants
 * @description: 服务名称常量
 * @author: lukewei
 * @date: 2019/10/16 12:31
 * @remark:
 */
public interface ServiceNameConstants {

    /**
     * 用户权限服务
     */
    String USER_SERVICE = "bjgyol-user-center";
    /**
     * 邮件服务中心
     */
    String EMAIL_SERVICE = "bjgyol-email-center";
    /**
     * 短信服务中心
     */
    String SMS_SERVICE = "bjgyol-sms-center";
    /**
     * 光大支付回调
     */
    String NOTIFY_SERVICE = "bjgyol-notify-center";
    /**
     * 搜索中心服务
     */
    String SEARCH_SERVICE = "bjgyol-search-center";
    /**
     * 分布式ID生成器服务
     */
    String DISTRUBUTE_ID_SERVICE = "bjgyol-idgenerator";
    /**
     * 产品中心缓存微服务
     */
    String PRODUCT_CACHE_SERVICE = "bjgyol-cache-center";
    /**
     * 产品中心微服务
     */
    String PRODUCT_SERVICE = "bjgyol-product-center";
    /**
     * 订单中心微服务
     */
    String ORDER_SERVICE = "bjgyol-order-center";

    /**
     * 文件管理中心
     */
    String FILE_SERVICE = "bjgyol-file-center";

    /**
     *  es查询中心
     */
    String ELASTICSEARCH_QUERY = "bjgyol-commons-elasticsearch-query";
}
