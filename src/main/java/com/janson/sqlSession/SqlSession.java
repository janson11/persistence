package com.janson.sqlSession;

import java.util.List;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2023/4/2 9:23
 **/
public interface SqlSession {

    /**
     * 查询所有
     */
    public <E> List<E> selectList(String statementId,Object... params);

    /**
     * 根据条件查询单个
     */
    public <T> T selectOne(String statementId,Object... params);
}
