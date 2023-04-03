package com.janson.sqlSession;

import com.janson.pojo.Configuration;
import com.janson.pojo.MappedStatement;

import java.util.List;
import java.util.Objects;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2023/4/3 8:31
 **/
public class SimpleExecutor  implements Executor{
    @Override
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) {
        return null;
    }
}
