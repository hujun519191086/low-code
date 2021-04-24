//package com.github.houbb.low.code.web.config;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.serializer.SerializeConfig;
//import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpOutputMessage;
//import org.springframework.http.converter.HttpMessageNotWritableException;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.Date;
//
///**
// * fastjson 会导致 jackson 的格式转换失效
// *
// * https://blog.csdn.net/duanleiyadang/article/details/79883144
// *
// * https://blog.csdn.net/weixin_35742195/article/details/113581471
// *
// * https://www.ericgg.com/archives/3846.html
// *
// * @author binbin.hou
// * @since 1.0.0
// */
//@Configuration
//public class FastJsonHttpDateConverter extends FastJsonHttpMessageConverter {
//
//    private static final SerializeConfig mapping = new SerializeConfig();
//
//    static {
//        mapping.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
//    }
//
//    @Override
//    protected void writeInternal(Object obj, HttpOutputMessage outputMessage)
//            throws IOException, HttpMessageNotWritableException {
//        OutputStream out = outputMessage.getBody();
//        String text = JSON.toJSONString(obj, mapping, this.getFeatures());
//        byte[] bytes = text.getBytes(this.getCharset());
//        out.write(bytes);
//    }
//
//}
