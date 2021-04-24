//package com.github.houbb.low.code.web.config;
//
//import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
//import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//
///**
// * @author binbin.hou
// * @since 1.0.0
// */
//@Configuration
//public class LocalDateTimeGlobalConfig {
//
//    /**
//     * Date格式化字符串
//     */
//    private static final String DATE_FORMAT = "yyyy-MM-dd";
//
//    /**
//     * DateTime格式化字符串
//     */
//    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
//
//    /**
//     * Time格式化字符串
//     */
//    private static final String TIME_FORMAT = "HH:mm:ss";
//
//    @Bean
//    @Primary
//    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
//        return builder -> builder
//                // 日期时间格式
//                .serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT)))
//                .serializerByType(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(DATE_FORMAT)))
//                .serializerByType(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern(TIME_FORMAT)))
//                .deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT)))
//                .deserializerByType(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(DATE_FORMAT)))
//                .deserializerByType(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern(TIME_FORMAT)))
//                // Jackson全局转化long类型为String，解决jackson序列化时long类型缺失精度问题
//                .serializerByType(Long.TYPE, ToStringSerializer.instance)
//                .serializerByType(Long.class, ToStringSerializer.instance);
//    }
//
//}
