package com.github.houbb.low.code.gen.builder;

import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.low.code.dal.entity.LcEnumMapping;
import com.github.houbb.low.code.gen.exception.LowCodeGenException;
import com.github.houbb.web.common.dto.option.Option;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class MyConfigBuilder extends ConfigBuilder {

    protected final Connection connection;

    /**
     * <p>
     * 在构造器中处理配置
     * </p>
     *
     * @param packageConfig    包配置
     * @param dataSourceConfig 数据源配置
     * @param strategyConfig   表配置
     * @param template         模板配置
     * @param globalConfig     全局配置
     */
    public MyConfigBuilder(PackageConfig packageConfig, DataSourceConfig dataSourceConfig, StrategyConfig strategyConfig, TemplateConfig template, GlobalConfig globalConfig) {
        super(packageConfig, dataSourceConfig, strategyConfig, template, globalConfig);

        this.connection = dataSourceConfig.getConn();
    }

    @Override
    public List<TableInfo> getTableInfoList() {
        List<TableInfo> tableInfos = super.getTableInfoList();

        for(TableInfo tableInfo : tableInfos) {
            // 统一处理对应的字段信息
            String tableName = tableInfo.getName();

            List<TableField> tableFields = tableInfo.getFields();

            // 自己实现对应的查询
            for(TableField tableField : tableFields) {
                String columnName = tableField.getName();

                Map<String, Object> map = new HashMap<>();
                // 查询枚举值信息
                List<Option> enumList = queryEnumMapping(tableName, columnName);
                if(CollectionUtil.isNotEmpty(enumList)) {
                    map.put("hasEnum", true);
                    map.put("enumMapping", enumList);
                } else {
                    map.put("hasEnum", false);
                }
                tableField.setCustomMap(map);
            }
        }
        return tableInfos;
    }

    /**
     * 查询枚举映射关系
     * @param tableName 表名称
     * @param columnName 列名称
     * @return 结果
     */
    private List<Option> queryEnumMapping(String tableName, String columnName) {
        try {
            String sql = "SELECT `key`, label from lc_enum_mapping where table_name = ? and column_name=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tableName);
            preparedStatement.setString(2, columnName);
            ResultSet results = preparedStatement.executeQuery();

            List<Option> list = new ArrayList<>();
            while (results.next()) {
                String key = results.getString("key");
                String label = results.getString("label");

                Option option = Option.of(key, label);
                System.out.println(key + " : " + label);

                list.add(option);
            }

            return list;
        } catch (SQLException e) {
            throw new LowCodeGenException(e);
        }
    }


}
