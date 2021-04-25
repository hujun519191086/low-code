package com.github.houbb.low.code.gen.config;

import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class PagePoFileOutConfig extends FileOutConfig {

    /**
     * 路径的格式
     * @since 0.0.3
     */
    private final String pathFormat;

    /**
     * 模板路径
     * @since 0.0.3
     */
    private final String templatePath;

    public PagePoFileOutConfig(String pathFormat) {
        this(pathFormat, "/templates/low-code/low-code-entity-page-po.java.ftl");
    }

    public PagePoFileOutConfig(String pathFormat, String templatePath) {
        this.pathFormat = pathFormat;
        this.templatePath = templatePath;
    }

    @Override
    public String outputFile(TableInfo tableInfo) {
        String entityName = tableInfo.getEntityName();
        return String.format(pathFormat, entityName);
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }

}
