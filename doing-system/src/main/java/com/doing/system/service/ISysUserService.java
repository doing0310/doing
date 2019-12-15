package com.doing.system.service;

import com.doing.system.bean.SysUser;

import java.util.List;

/**
 * @Effect 用户业务层
 * @Author doing
 * @Date 2019/12/13 15:58
 * @Version 0.0.1
 **/
public interface ISysUserService {

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    public SysUser selectUserByLoginName(String userName,String password);

}
