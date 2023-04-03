package com.janson.sqlSession;

import com.janson.pojo.Configuration;
import com.janson.pojo.MappedStatement;

import java.util.List;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2023/4/3 8:29
 **/
public interface Executor {
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params);
}
