package com.amuseboy.springes.dao;

import com.amuseboy.springes.dto.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @ClassName: ProductRepository
 * @Description: TODO
 * @Author: 55285
 * @Date: 2025/5/27 14:12
 */
public interface ProductRepository extends ElasticsearchRepository<Product, Long> {

    List<Product> findByName(String name);

    List<Product> findByTags(String tag);

}
