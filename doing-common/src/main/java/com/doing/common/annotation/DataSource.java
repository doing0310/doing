package com.doing.common.annotation;

import com.doing.common.enums.DataSourceType;
import java.lang.annotation.*;

/**
 * @Effect 自定义多数据源切换注解
 * @Author doing
 * @Date 2019/11/30 11:42
 * @Version 0.0.1
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource{
    public DataSourceType value() default DataSourceType.MASTER;
}
