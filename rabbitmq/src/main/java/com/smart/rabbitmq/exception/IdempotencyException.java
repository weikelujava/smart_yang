/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0.0
 * @title: 幂等性异常
 * @description:
 * @author: hollysmart
 * @date: 2019/10/16 12:31
 * @remark:
 */

package com.smart.rabbitmq.exception;

public class IdempotencyException extends RuntimeException {
    private static final long serialVersionUID = 6610083281801529147L;

    public IdempotencyException(String message) {
        super(message);
    }
}
