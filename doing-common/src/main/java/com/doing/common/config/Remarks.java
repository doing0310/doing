package com.doing.common.config;

import com.doing.common.utils.StringUtils;
import com.doing.common.utils.YamlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Effect 全局配置类
 * @Author doing
 * @Date 2019/12/6 21:26
 * @Version 0.0.1
 **/
public class Remarks {
    private static final Logger log = LoggerFactory.getLogger(Remarks.class);

    private static String NAME = "application.yml";

    /**
     * 当前对象实例
     */
    private static Remarks remarks;

    /**
     * 保存全局属性值
     */
    private static Map<String, String> map = new HashMap<String, String>();

    private Remarks()
    {
    }

    /**
     * 静态工厂方法
     */
    public static synchronized Remarks getInstance()
    {
        if (remarks == null)
        {
            remarks = new Remarks();
        }
        return remarks;
    }

    /**
     * 获取配置
     */
    public static String getConfig(String key)
    {
        String value = map.get(key);
        if (value == null)
        {
            Map<?, ?> yamlMap = null;
            try
            {
                yamlMap = YamlUtil.loadYaml(NAME);
                value = String.valueOf(YamlUtil.getProperty(yamlMap, key));
                map.put(key, value != null ? value : StringUtils.EMPTY);
            }
            catch (FileNotFoundException e)
            {
                log.error("获取全局配置异常 {}", key);
            }
        }
        return value;
    }

    /**
     * 获取项目名称
     */
    public static String getName()
    {
        return StringUtils.nvl(getConfig("doing.name"), "doing");
    }

    /**
     * 获取项目版本
     */
    public static String getVersion()
    {
        return StringUtils.nvl(getConfig("doing.version"), "4.0.0");
    }

    /**
     * 获取版权年份
     */
    public static String getCopyrightYear()
    {
        return StringUtils.nvl(getConfig("doing.copyrightYear"), "2019");
    }

}
