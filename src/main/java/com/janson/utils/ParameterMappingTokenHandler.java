package com.janson.utils;

import com.janson.pojo.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2023/4/5 10:46
 **/
public class ParameterMappingTokenHandler  implements TokenHandler {
    private final List<ParameterMapping> parameterMappings = new ArrayList<>();

    public ParameterMappingTokenHandler() {
    }

    public List<ParameterMapping> getParameterMappings() {
        return parameterMappings;
    }

    @Override
    public String handleToken(String content) {
        parameterMappings.add(buildParameterMapping(content));
        return "?";
    }

    private ParameterMapping buildParameterMapping(String content) {
        Map<String, String> propertiesMap = parseParameterMapping(content);
        String property = propertiesMap.get("property");
        String jdbcType = propertiesMap.get("jdbcType");
        Class<?> propertyType;
        if (typeHandlerRegistry.hasTypeHandler(parameterType)) {
            propertyType = parameterType;
        } else if (JdbcType.CURSOR.name().equals(jdbcType)) {
            propertyType = java.sql.ResultSet.class;
        } else if (property != null) {
            MetaClass metaClass = MetaClass.forClass(parameterType, configuration.getReflectorFactory());
            if (metaClass.hasGetter(property)) {
                propertyType = metaClass.getGetterType(property);
            } else {
                propertyType = Object.class;
            }
        } else {
            propertyType = Object.class;
        }
        ParameterMapping.Builder builder = new ParameterMapping.Builder(configuration, property, propertyType);
        if (jdbcType != null) {
            builder.jdbcType(resolveJdbcType(jdbcType));
        }
        Class<?> javaType = null;
        String typeHandlerAlias = null;
        for (Map.Entry<String, String> entry : propertiesMap.entrySet()) {
            String name = entry.getKey();
            String value = entry.getValue();
            if ("javaType".equals(name)) {
                javaType = resolveClass(value);
                builder.javaType(javaType);
            } else if ("jdbcType".equals(name)) {
                builder.jdbcType(resolveJdbcType(value));
            } else if ("mode".equals(name)) {
                builder.mode(resolveParameterMode(value));
            } else if ("numericScale".equals(name)) {
                builder.numericScale(Integer.valueOf(value));
            } else if ("resultMap".equals(name)) {
                builder.resultMapId(value);
            } else if ("typeHandler".equals(name)) {
                typeHandlerAlias = value;
            } else if ("jdbcTypeName".equals(name)) {
                builder.jdbcTypeName(value);
            } else if ("property".equals(name)) {
                // Do Nothing
            } else if ("expression".equals(name)) {
                builder.expression(value);
            } else {
                throw new BuilderException("An invalid property '" + name + "' was found in mapping @{" + content
                        + "}.  Valid properties are " + parameterProperties);
            }
        }
        if (typeHandlerAlias != null) {
            builder.typeHandler(resolveTypeHandler(javaType, typeHandlerAlias));
        }
        return builder.build();
    }

    private Map<String, String> parseParameterMapping(String content) {
        try {
            return new ParameterExpression(content);
        } catch (BuilderException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new BuilderException("Parsing error was found in mapping @{" + content
                    + "}.  Check syntax #{property|(expression), var1=value1, var2=value2, ...} ", ex);
        }
    }
}
