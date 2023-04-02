package com.janson.pojo;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2023/4/1 16:49
 **/
public class MappedStatement {

    /**
     * id标识
     */
    public String id;

    /**
     * 返回类型
     */
    public String resultType;

    /**
     * 参数值类型
     */
    private String parameterType;

    /**
     * sql语句
     */
    private String sql;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
