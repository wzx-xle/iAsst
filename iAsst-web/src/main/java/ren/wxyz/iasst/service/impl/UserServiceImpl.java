/**
 * Copyright (C) 2001-2016 wxyz <hyhjwzx@126.com>
 * <p>
 * This program can be distributed under the terms of the GNU GPL Version 2.
 * See the file LICENSE.
 */
package ren.wxyz.iasst.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ren.wxyz.iasst.dao.mapper.UserMapper;
import ren.wxyz.iasst.domain.persistent.User;
import ren.wxyz.iasst.exception.BusinessException;
import ren.wxyz.iasst.helper.bean.ExceptionType;
import ren.wxyz.iasst.service.UserService;

/**
 * 实现用户相关的服务
 *
 * @auther wxyz 2016-08-18_00:41
 * @since 0.1
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        // TODO 校验

        User user = userMapper.selectByUsername(username);
        if (null == user) {
            throw new BusinessException(ExceptionType.USER_NOT_FOUND);
        }
        if (!user.checkPassword(password)) {
            throw new BusinessException(ExceptionType.USERNAME_PASSWORD_ERROR);
        }

        return user;
    }
}
