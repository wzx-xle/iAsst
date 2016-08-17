/**
 * Copyright (C) 2001-2016 wxyz <hyhjwzx@126.com>
 * <p>
 * This program can be distributed under the terms of the GNU GPL Version 2.
 * See the file LICENSE.
 */
package ren.wxyz.iasst.service;

import ren.wxyz.iasst.domain.User;

/**
 * 用户服务
 *
 * @auther wxyz
 * @since 0.1
 */
public interface UserService {
  /**
   * 通过登陆信息来获取用户
   *
   * @param loginInfo 登陆信息
   * @return 用户对象
   */
  User getUserByLoginInfo(String loginInfo);
}
