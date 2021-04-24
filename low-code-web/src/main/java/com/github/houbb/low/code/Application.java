package com.github.houbb.low.code;

import com.github.houbb.auto.log.spring.annotation.EnableAutoLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author binbin.hou
 * @since 0.0.1
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableAutoLog
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
