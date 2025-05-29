package com.amuseboy.springes.dto;

import com.amuseboy.springes.config.BigDecimalPlainSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.suggest.Completion;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: Product
 * @Description: TODO
 * @Author: 55285
 * @Date: 2025/5/27 14:06
 */
@Document(indexName = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private Long id;

    /**
     * 商品名称：支持分词搜索 & 精确搜索
     */
    //@Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    @Field(type = FieldType.Text)
    private String name;

    /**
     * 精确关键词：比如商品编号、分类ID等（不可分词）
     */
    @Field(type = FieldType.Keyword)
    private String categoryCode;

    /**
     * 价格字段：使用 double 类型（不需要精确计算时推荐）
     */
    @JsonSerialize(using = BigDecimalPlainSerializer.class)
    @Field(type = FieldType.Double)
    private BigDecimal price;

    /**
     * 上架时间：时间字段，可用于时间范围过滤
     */
    @Field(type = FieldType.Date, format = DateFormat.date_optional_time)
    private Date createTime;

    /**
     * 商品标签：多值 keyword，用于聚合、筛选、精确匹配
     */
    @Field(type = FieldType.Keyword)
    private List<String> tags;

    /**
     * 地理位置字段：可用于地理距离排序、范围查询
     */
    @GeoPointField
    private GeoPoint location;

    /**
     * 自动补全字段：用于 suggest/搜索提示功能
     */
    @CompletionField(maxInputLength = 100)
    private Completion suggest;

    /**
     * 嵌套属性：商品的多个SKU信息，结构化且可独立查询
     */
    @Field(type = FieldType.Nested)
    private List<Sku> skuList;

}
