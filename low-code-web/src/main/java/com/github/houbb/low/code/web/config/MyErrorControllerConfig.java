package com.github.houbb.low.code.web.config;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Component;

/**
 * 发生错误时，是哪一个 controller 来处理？
 * @author binbin.hou
 * @since 0.0.3
 */
@Component
public class MyErrorControllerConfig implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
