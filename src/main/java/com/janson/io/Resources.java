package com.janson.io;

import java.io.InputStream;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2023/4/1 15:27
 **/
public class Resources {

    // 根据配置文件的路径，将配置文件加载成字节输入流，存储在内存中
    public static InputStream getResourceStream(String path) {
        InputStream resourceAsStream = Resources.class.getClassLoader().getResourceAsStream(path);
        return resourceAsStream;
    }

}
