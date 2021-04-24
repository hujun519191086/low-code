package com.github.houbb.low.code.gen.config;

import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.github.houbb.heaven.util.lang.StringUtil;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class VueFileOutConfig extends FileOutConfig {

    /**
     * 路径的格式
     * @since 0.0.2
     */
    private final String pathFormat;

    /**
     * 模板路径
     * @since 0.0.2
     */
    private final String templatePath;

    public VueFileOutConfig(String pathFormat) {
        this(pathFormat, "/templates/low-code/low-code-index.html.ftl");
    }

    public VueFileOutConfig(String pathFormat, String templatePath) {
        this.pathFormat = pathFormat;
        this.templatePath = templatePath;
    }

    @Override
    public String outputFile(TableInfo tableInfo) {
        String entityName = tableInfo.getEntityName();
        String lowerCase = StringUtil.firstToLowerCase(entityName);

        return String.format(pathFormat, lowerCase);
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }
}
