package com.doing.system.service.impl;

import com.doing.system.bean.SysUser;
import com.doing.system.mapper.SysUserMapper;
import com.doing.system.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Effect 用户业务层处理
 * @Author doing
 * @Date 2019/12/13 15:59
 * @Version 0.0.1
 **/
@Service
public class SysUserServiceImpl implements ISysUserService {

    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserMapper userMapper;


    @Override
    public SysUser selectUserByLoginName(String userName, String password) {
        return userMapper.selectUserByLoginName(userName,password);
    }
}
