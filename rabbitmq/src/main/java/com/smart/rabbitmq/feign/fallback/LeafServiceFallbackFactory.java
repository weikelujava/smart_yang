//package com.smart.rabbitmq.feign.fallback;
//
//import com.smart.rabbitmq.common.ResultEntity;
//import com.smart.rabbitmq.feign.LeafService;
//import feign.hystrix.FallbackFactory;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
///**
// *
// * @version V1.0
// * @title: LeafServiceFallbackFactory
// * @description:
// * @author: lukewei
// * @date: 2019/12/20 17:00
// * @remark: 修改内容
// */
//@Slf4j
//@Component
//public class LeafServiceFallbackFactory implements FallbackFactory<LeafService> {
//    @Override
//    public LeafService create(Throwable throwable) {
//        return new LeafService() {
//            @Override
//            public ResultEntity generateIdBySnowFlake() {
//                log.error("通过雪花算法生成分布式唯一ID发生错误:{}", throwable);
//                return new ResultEntity();
//            }
//        };
//    }
//}
