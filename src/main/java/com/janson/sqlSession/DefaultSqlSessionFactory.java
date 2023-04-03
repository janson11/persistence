package com.janson.sqlSession;

import com.janson.pojo.Configuration;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2023/4/2 9:14
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
