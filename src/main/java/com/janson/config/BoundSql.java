package com.janson.config;

import com.janson.utils.ParameterMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2023/4/3 22:06
 **/
public class BoundSql {

    private String sqlText;
    private List<ParameterMapping> parameterMappingList = new ArrayList<ParameterMapping>();

    public BoundSql() {
    }

    public BoundSql(String sqlText, List<ParameterMapping> parameterMappingList) {
        this.sqlText = sqlText;
        this.parameterMappingList = parameterMappingList;
    }

    public String getSqlText() {
        return sqlText;
    }

    public void setSqlText(String sqlText) {
        this.sqlText = sqlText;
    }

    public List<ParameterMapping> getParameterMappingList() {
        return parameterMappingList;
    }

    public void setParameterMappingList(List<ParameterMapping> parameterMappingList) {
        this.parameterMappingList = parameterMappingList;
    }
}
