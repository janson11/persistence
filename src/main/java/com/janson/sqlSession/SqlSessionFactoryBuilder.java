package com.janson.sqlSession;

import com.janson.config.XMLConfigBuilder;
import com.janson.pojo.Configuration;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2023/4/1 17:02
 **/
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream in) throws PropertyVetoException, DocumentException {
        // 第一:使用dom4j解析配置文件，将解析出来的内容封装到Configuration中
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(in);



        // 第二 :创建SqlSessionFactory对象
    }

}
