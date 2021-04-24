package com.github.houbb.low.code.gen.engine;


import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;

/**
 * FTL 引擎生成接口
 * @author binbin.hou
 * @since 0.0.2
 */
public interface IFtlEngine {

    /**
     * 批量输出待生成的文件
     * @return this
     * @since 0.0.2
     */
    IFtlEngine batchOutput();

    /**
     * 初始化
     * @param configBuilder 配置
     * @return this
     * @since 0.0.2
     */
    IFtlEngine init(ConfigBuilder configBuilder);

    /**
     * 创建文件夹
     * @return 文件夹
     * @since 0.0.2
     */
    IFtlEngine mkdirs();

    /**
     * 打开生成文件所在的位置
     * @since 0.0.2
     */
    void open();

}
