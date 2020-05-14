//package com.smart.rabbitmq.feign;
//
//import com.smart.rabbitmq.common.ResultEntity;
//import com.smart.rabbitmq.constant.ServiceNameConstants;
//import com.smart.rabbitmq.feign.fallback.LeafServiceFallbackFactory;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//
///**
// * @version V1.0
// * @title: LeafService
// * @description:
// * @author: lukewei
// * @date: 2019/12/20 16:59
// * @remark: 修改内容
// */
//@FeignClient(name = ServiceNameConstants.DISTRUBUTE_ID_SERVICE, fallbackFactory = LeafServiceFallbackFactory.class, decode404 = true)
//public interface LeafService {
//
//    /**
//     * feign rpc访问远程ID雪花生成器接口
//     *
//     * @return
//     */
//    @GetMapping(value = "/generate/snowflake/id")
//    ResultEntity generateIdBySnowFlake();
//}