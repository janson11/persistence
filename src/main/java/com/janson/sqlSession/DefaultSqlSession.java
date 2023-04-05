package com.janson.sqlSession;

import com.janson.pojo.Configuration;
import com.janson.pojo.MappedStatement;

import java.util.List;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2023/4/2 9:23
 **/
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> selectList(String statementId, Object... params) throws Exception {
        //  将要完成对simpleExecutor里的query 方法的调用。
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementId);

        List<E> query = simpleExecutor.query(configuration, mappedStatement, params);

        return query;
    }

    @Override
    public <T> T selectOne(String statementId, Object... params) throws Exception {
        List<Object> objects = selectList(statementId, params);
        if (objects.size() == 1) {
            return (T) objects.get(0);
        } else {
            throw new RuntimeException("查询结果为空或者返回结果过多");
        }
    }
}
