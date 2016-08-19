/**
 * Copyright (C) 2001-2016 wxyz <hyhjwzx@126.com>
 * <p>
 * This program can be distributed under the terms of the GNU GPL Version 2.
 * See the file LICENSE.
 */
package ren.wxyz.iasst.service;

import ren.wxyz.iasst.domain.persistent.User;

/**
 * 用户服务
 *
 * @auther wxyz 2016-08-18_00:41
 * @since 0.1
 */
public interface UserService {

    /**
     * 登陆校验
     *
     * @param username 用户名
     * @param password 密码
     * @return 登陆成功的用户
     */
    User login(String username, String password);
}
