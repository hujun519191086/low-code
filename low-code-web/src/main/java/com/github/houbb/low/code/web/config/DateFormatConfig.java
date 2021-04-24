//package com.github.houbb.low.code.web.config;
//
//import com.fasterxml.jackson.databind.SerializationFeature;
//import javafx.util.converter.LocalDateStringConverter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
//import org.springframework.boot.jackson.JsonComponent;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.TimeZone;
//
///**
// * https://blog.csdn.net/weixin_35742195/article/details/113581471
// *
// * @author binbin.hou
// * @since 1.0.0
// */
//@JsonComponent
//public class DateFormatConfig {
//
//
//    @Value("${spring.jackson.date-format:yyyy-MM-dd HH:mm:ss}")
//    private String datePattern;
//
//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
//        return jacksonObjectMapperBuilder -> {
//            TimeZone timeZone = TimeZone.getTimeZone("UTC");
//            DateFormat dateFormat = new SimpleDateFormat(datePattern);
//            dateFormat.setTimeZone(timeZone);
//
//            jacksonObjectMapperBuilder.failOnEmptyBeans(false)
//                    .failOnUnknownProperties(false)
//                    .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
//                    .dateFormat(dateFormat);
//        };
//    }
//
//}
