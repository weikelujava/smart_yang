package com.smart.canal.repository;

import com.smart.canal.bean.BlcCategory;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: BlcCategoryRepository
 * @description:
 * @author: lukewei
 * @date: 2020-5-16 12:45:00
 * @remark: 修改内容
 */
@Repository
public interface BlcCategoryRepository extends ElasticsearchRepository<BlcCategory, Long> {
}
