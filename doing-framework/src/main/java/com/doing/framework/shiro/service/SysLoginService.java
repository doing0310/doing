package com.doing.framework.shiro.service;

import com.doing.common.exception.user.UserException;
import com.doing.system.bean.SysUser;
import com.doing.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Effect 登录校验方法
 * @Author doing
 * @Date 2019/12/13 15:35
 * @Version 0.0.1
 **/
@Component
public class SysLoginService {

    @Autowired
    private ISysUserService userService;

    /**
     * 登录
     */
    public SysUser login(String username, String password)
    {
        // 用户名或密码为空 错误
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
        {
            throw new UserException("用户名或密码为空");
        }

        // 查询用户信息
        SysUser user = userService.selectUserByLoginName(username,password);

        if (user == null)
        {
            throw new UserException("用户名不存在");
        }

        return user;
    }
}
