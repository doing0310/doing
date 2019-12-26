package com.doing.common.exception.user;

import com.doing.common.exception.base.BaseException;

/**
 * @Effect 用户信息异常类
 * @Author doing
 * @Date 2019/12/25 11:27
 * @Version 0.0.1
 **/
public class UserException extends BaseException {
    public UserException(String defaultMessage) {
        super(defaultMessage);
    }
}
