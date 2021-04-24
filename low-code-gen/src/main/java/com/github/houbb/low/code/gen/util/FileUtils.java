package com.github.houbb.low.code.gen.util;

import java.io.File;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public final class FileUtils {

    private FileUtils(){}


    /**
     * 创建文件夹
     * @param file 文件
     * @since 0.0.2
     */
    public static void mkDir(File file) {
        if (null != file) {
            if (file.getParentFile().exists()) {
                file.mkdir();
            } else {
                mkDir(file.getParentFile());
                file.mkdir();
            }
        }
    }

}
