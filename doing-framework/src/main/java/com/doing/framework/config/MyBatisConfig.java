package com.doing.framework.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.jboss.logging.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * @Effect Mybatis支持*匹配扫描包
 * @Author doing
 * @Date 2019/12/13 17:46
 * @Version 0.0.1
 **/
@Configuration
public class MyBatisConfig {

    /**
     * Mapper扫描配置. 自动扫描将Mapper接口生成代理注入到Spring.
     */
    @Bean
    public static MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        // 注意这里的扫描路径: 1.不要扫描到自定义的Mapper; 2.定义的路径不要扫描到tk.mybatis.mapper(如定义**.mapper).
        // 两个做法都会导致扫描到tk.mybatis的Mapper，就会产生重复定义的报错.
        mapperScannerConfigurer.setBasePackage("com.doing.**.mapper");
        return mapperScannerConfigurer;
    }
}
