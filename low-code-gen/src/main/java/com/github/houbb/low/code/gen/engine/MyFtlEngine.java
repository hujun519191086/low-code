package com.github.houbb.low.code.gen.engine;

import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.github.houbb.heaven.support.filter.IFilter;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        List<TableField> fieldList = tableInfo.getFields();

        // 新增字段
        List<TableField> filterFields = CollectionUtil.filterList(fieldList, new IFilter<TableField>() {
            @Override
            public boolean filter(TableField tableField) {
                List<String> ignoreList = Arrays.asList("id", "createTime", "updateTime");
                String tableFieldName = tableField.getPropertyName();
                return ignoreList.contains(tableFieldName);
            }
        });

        map.put("queryFields", filterFields);
        map.put("addFields", filterFields);
        map.put("editFields", filterFields);

        return map;
    }

}
