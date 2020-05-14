package com.smart.rabbitmq.common;

import com.smart.rabbitmq.enums.Status;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @version V1.0
 * @title: ResultEntity
 * @description: 分布式唯一ID
 * @author: lukewei
 * @date: 2019/12/20 16:37
 * @remark:
 */
@Getter
@Setter
public class ResultEntity {
    private Long id;
    private Status status;

    public ResultEntity() {

    }

    public ResultEntity(Long id, Status status) {
        this.id = id;
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResultWrapper{");
        sb.append("id=").append(id);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
