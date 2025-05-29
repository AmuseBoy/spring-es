package com.amuseboy.springes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;

/**
 * @ClassName: Sku
 * @Description: TODO
 * @Author: 55285
 * @Date: 2025/5/29 11:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sku {

    @Field(type = FieldType.Keyword)
    private String skuCode;

    @Field(type = FieldType.Text)
    private String skuName;

    @Field(type = FieldType.Double)
    private BigDecimal price;

}
