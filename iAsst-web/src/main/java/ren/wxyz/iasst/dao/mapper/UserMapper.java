/**
 * Copyright (C) 2001-2016 wxyz <hyhjwzx@126.com>
 * <p>
 * This program can be distributed under the terms of the GNU GPL Version 2.
 * See the file LICENSE.
 */
package ren.wxyz.iasst.dao.mapper;

import ren.wxyz.iasst.domain.persistent.User;

/**
 * 用户的对象关系映射处理
 *
 * @auther wxyz 2016-08-18_16:01
 * @since 0.1
 */
public interface UserMapper {

    User selectByUsername(String username);
}
