package com.github.houbb.low.code.gen.cleaner;

import com.github.houbb.heaven.util.io.FileUtil;
import com.github.houbb.heaven.util.lang.StringUtil;

import java.io.File;

/**
 * 清空生成的代码
 * @author binbin.hou
 * @since 0.0.1
 */
public class MPCleaner {

    /**
     * 覆盖生成下列文件，第一次建表时使用
     * 1. java mapper
     * 2. java entity
     * 3. xml mapper
     * 4. service
     * 5. control
     * 6. html
     *
     * 更新时使用：
     * 1. 只修改对应的实体类即可，其他注释掉。
     */
    public static void main(String[] args) {
        String[] tables = new String[]{
                "user",
        };

        for(String table : tables) {
            String entityName = StringUtil.firstToUpperCase(StringUtil.underlineToCamel(table));
            cleanDalJavaEntity(entityName);
            cleanDalJavaMapper(entityName);
            cleanDalXml(entityName);
            cleanService(entityName);
            cleanController(entityName);
            cleanVue(entityName);
            cleanPagePo(entityName);
        }
    }

    private static final String BASE_DIR = System.getProperty("user.dir");

    /**
     * 生成 dal 的 pagePo 代码
     * @param entityName 实例名称
     * @since 0.0.1
     */
    private static void cleanPagePo(String entityName) {
        final String pathFormat = BASE_DIR + "/low-code-dal/src\\main\\java\\com\\github\\houbb\\low\\code\\dal\\entity\\po\\"+entityName+"PagePo.java";
        FileUtil.deleteFile(new File(pathFormat));
    }

    /**
     * 生成 dal 的 java 代码
     * @param entityName 实例名称
     * @since 0.0.1
     */
    private static void cleanVue(String entityName) {
        String lowerCase = StringUtil.firstToLowerCase(entityName);

        final String path = BASE_DIR + "/low-code-web/src\\main\\resources\\templates\\"+lowerCase+"\\index.html";
        System.out.println(path);
        FileUtil.deleteFile(new File(path));
    }

    /**
     * 生成 dal 的 java 代码
     * @param entityName 实例名称
     * @since 0.0.1
     */
    private static void cleanDalJavaEntity(String entityName) {
        String moduleName = "low-code-dal";

        String path = BASE_DIR+"/"+moduleName+
                "\\src\\main\\java\\com\\github\\houbb\\low\\code\\dal\\entity\\"+entityName+".java";
        System.out.println(path);
        FileUtil.deleteFile(new File(path));
    }

    /**
     * 生成 dal 的 java mapper 代码
     * @param entityName 实例名称
     * @since 0.0.1
     */
    private static void cleanDalJavaMapper(String entityName) {
        String moduleName = "low-code-dal";

        String path = BASE_DIR+"/"+moduleName+
                "\\src\\main\\java\\com\\github\\houbb\\low\\code\\dal\\mapper\\"+entityName+"Mapper.java";
        System.out.println(path);
        FileUtil.deleteFile(new File(path));
    }

    /**
     * @param entityName 实例名称
     * @since 0.0.1
     */
    private static void cleanDalXml(String entityName) {
        String moduleName = "low-code-dal";

        String path = BASE_DIR+"/"+moduleName+
                "\\src\\main\\resources\\com\\github\\houbb\\low\\code\\dal\\mapper\\"+entityName+"Mapper.xml";
        System.out.println(path);
        FileUtil.deleteFile(new File(path));
    }

    private static void cleanService(String entityName) {
        String moduleName = "low-code-service";
        String path = BASE_DIR+"/"+moduleName+
                "\\src\\main\\java\\com\\github\\houbb\\low\\code\\service\\service\\"+entityName+"Service.java";
        System.out.println(path);
        FileUtil.deleteFile(new File(path));

        String path2 = BASE_DIR+"/"+moduleName+
                "\\src\\main\\java\\com\\github\\houbb\\low\\code\\service\\service\\impl\\"+entityName+"ServiceImpl.java";
        System.out.println(path);
        FileUtil.deleteFile(new File(path2));
    }

    private static void cleanController(String entityName) {
        String moduleName = "low-code-web";
        String path = BASE_DIR+"/"+moduleName+
                "\\src\\main\\java\\com\\github\\houbb\\low\\code\\web\\controller\\"+entityName+"Controller.java";
        System.out.println(path);
        FileUtil.deleteFile(new File(path));
    }

}
