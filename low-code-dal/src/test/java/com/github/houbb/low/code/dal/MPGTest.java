//package com.github.houbb.low.code.dal;
//
//import com.baomidou.mybatisplus.enums.IdType;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.rules.DbType;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//
///**
// * @author binbin.hou
// * @since 0.0.1
// */
//public class MPGTest {
//
//    /**
//     * 覆盖生成下列文件，第一次建表时使用
//     * 1. java mapper
//     * 2. java enity
//     * 3. xml mapper
//     * 4. service
//     *
//     * 更新时使用：
//     * 1. 只修改对应的实体类即可，其他科注释掉。
//     *
//     * genDalJavaEntity
//     */
//    public static void main(String[] args) {
//        String[] tables = new String[]{
//                "user",
//        };
//
//        genDalJavaEntity(tables);
//        genDalJavaMapper(tables);
//        genDalXml(tables);
//        genService(tables);
//        genController(tables);
//    }
//
//    private static final String BASE_DIR = System.getProperty("user.dir");
//
//    private static AutoGenerator initConfig(String... tables) {
//        final String author = System.getProperty("user.name");
//
//        //创建代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//        //指定模板引擎  默认velocity
//        //mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//
//        //全局配置
//        GlobalConfig gc = new GlobalConfig();
//        gc.setOpen(false);
//        gc.setOutputDir(BASE_DIR);
//        gc.setFileOverride(true); //是否覆盖已有文件
//        gc.setBaseResultMap(false); //XML是否需要BaseResultMap
//        gc.setBaseColumnList(false); //XML是否显示字段
//        gc.setActiveRecord(false);  //关闭 activeRecord 模式
//        gc.setControllerName("%sController");
//        gc.setServiceName("%sService");
//        gc.setServiceImplName("%sServiceImpl");
//        gc.setMapperName("%sMapper");
//        gc.setXmlName("%sMapper");
//        gc.setAuthor(author);
//        gc.setEnableCache(false);
//        gc.setIdType(IdType.AUTO);
//
//        mpg.setGlobalConfig(gc);
//
//        //数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setDbType(DbType.MYSQL);
//        dsc.setDriverName("com.mysql.jdbc.Driver");
//        dsc.setUrl("jdbc:mysql://localhost:3306/lowcode");
//        dsc.setUsername("root");
//        dsc.setPassword("123456");
//        mpg.setDataSource(dsc);
//
//        //策略配置
//        StrategyConfig sc = new StrategyConfig();
//        sc.setNaming(NamingStrategy.underline_to_camel); //表名生成策略
//        sc.setEntityBuilderModel(false);
//        sc.setCapitalMode(true);
//        sc.setEntityLombokModel(false);
//        sc.setDbColumnUnderline(true);
//        sc.setEntityColumnConstant(false); //生成字段常量
//        // 指定表信息
//        sc.setInclude(tables);
//        sc.entityTableFieldAnnotationEnable(true);
//        mpg.setStrategy(sc);
//
//        //包配置
//        PackageConfig pc = new PackageConfig();
//        pc.setParent("com.github.houbb.low.code");
//        pc.setEntity("dal.entity");
//        pc.setMapper("dal.mapper");
//        pc.setXml("dal.mapper");
//        pc.setService("service.service");
//        pc.setServiceImpl("service.service.impl");
//        pc.setController("web.controller");
//        mpg.setPackageInfo(pc);
//
//        // 配置模板
//        TemplateConfig templateConfig = new TemplateConfig();
//        //控制 不生成 controller  空字符串就行
//        templateConfig.setController("");
//        templateConfig.setService("");
//        templateConfig.setServiceImpl("");
//        templateConfig.setEntity("");
//        templateConfig.setMapper("");
//        templateConfig.setXml("");
//        mpg.setTemplate(templateConfig);
//
//        return mpg;
//    }
//
//    /**
//     * 生成 dal 的 java 代码
//     * @param tables 表名称
//     * @since 0.0.1
//     */
//    private static void genDalJavaEntity(String... tables) {
//        String moduleName = "low-code-dal";
//        AutoGenerator mpg = initConfig(tables);
//
//        mpg.getGlobalConfig().setOutputDir(BASE_DIR+"/"+moduleName+"\\src\\main\\java\\");
//        mpg.getTemplate().setEntity(ConstVal.TEMPLATE_ENTITY_JAVA);
//
//        mpg.execute();
//    }
//
//    /**
//     * 生成 dal 的 java mapper 代码
//     * @param tables 表名称
//     * @since 0.0.1
//     */
//    private static void genDalJavaMapper(String... tables) {
//        String moduleName = "low-code-dal";
//        AutoGenerator mpg = initConfig(tables);
//
//        mpg.getGlobalConfig().setOutputDir(BASE_DIR+"/"+moduleName+"\\src\\main\\java\\");
//        mpg.getTemplate().setMapper(ConstVal.TEMPLATE_MAPPER);
//
//        mpg.execute();
//    }
//
//    /**
//     * @param tables 表名称
//     * @since 0.0.1
//     */
//    private static void genDalXml(String... tables) {
//        String moduleName = "low-code-dal";
//        AutoGenerator mpg = initConfig(tables);
//
//        mpg.getGlobalConfig().setOutputDir(BASE_DIR+"/"+moduleName+"\\src\\main\\resources\\");
//        mpg.getTemplate().setXml(ConstVal.TEMPLATE_XML);
//
//        mpg.execute();
//    }
//
//    private static void genService(String... tables) {
//        String moduleName = "low-code-service";
//        AutoGenerator mpg = initConfig(tables);
//
//        mpg.getGlobalConfig().setOutputDir(BASE_DIR+"/"+moduleName+"\\src\\main\\java\\");
//        mpg.getTemplate().setService(ConstVal.TEMPLATE_SERVICE);
//        mpg.getTemplate().setServiceImpl(ConstVal.TEMPLATE_SERVICEIMPL);
//
//        mpg.execute();
//    }
//
//    private static void genController(String... tables) {
//        String moduleName = "low-code-web";
//        AutoGenerator mpg = initConfig(tables);
//
//        mpg.getGlobalConfig().setOutputDir(BASE_DIR+"/"+moduleName+"\\src\\main\\java\\");
//        mpg.getTemplate().setController(ConstVal.TEMPLATE_CONTROLLER);
//
//        mpg.execute();
//    }
//
//}
