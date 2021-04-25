package com.github.houbb.low.code.gen.engine;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.github.houbb.heaven.util.lang.StringUtil;

import java.util.Map;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class MyFtlEngine extends FreemarkerTemplateEngine {

    @Override
    public Map<String, Object> getObjectMap(TableInfo tableInfo) {
        Map<String, Object> map = super.getObjectMap(tableInfo);
        String serviceName = tableInfo.getServiceName();
        String serviceNameLower = StringUtil.firstToLowerCase(serviceName);
        map.put("serviceNameLower", serviceNameLower);
        return map;
    }

}
