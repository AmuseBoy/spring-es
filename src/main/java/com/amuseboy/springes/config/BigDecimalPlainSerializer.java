package com.amuseboy.springes.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * @ClassName: BigDecimalPlainSerializer
 * @Description: TODO
 * @Author: 55285
 * @Date: 2025/5/28 15:48
 */
public class BigDecimalPlainSerializer extends JsonSerializer<BigDecimal> {
    @Override
    public void serialize(BigDecimal bigDecimal, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(bigDecimal.toPlainString());
    }
}
