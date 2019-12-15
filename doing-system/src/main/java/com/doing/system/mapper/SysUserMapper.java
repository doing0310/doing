package com.doing.system.mapper;

import com.doing.system.bean.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Effect 用户 业务层
 * @Author doing
 * @Date 2019/12/13 16:07
 * @Version 0.0.1
 **/
@Mapper
public interface SysUserMapper {

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    public SysUser selectUserByLoginName(String userName,String password);
}
