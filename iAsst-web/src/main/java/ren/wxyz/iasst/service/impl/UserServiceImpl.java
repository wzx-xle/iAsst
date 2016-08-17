/**
 * Copyright (C) 2001-2016 wxyz <hyhjwzx@126.com>
 * <p>
 * This program can be distributed under the terms of the GNU GPL Version 2.
 * See the file LICENSE.
 */
package ren.wxyz.iasst.service.impl;

import org.springframework.stereotype.Service;
import ren.wxyz.iasst.domain.User;
import ren.wxyz.iasst.service.UserService;

/**
 * 实现用户相关的服务
 *
 * @auther wxyz
 * @since 0.1
 */
@Service
public class UserServiceImpl implements UserService {

  @Override
  public User getUserByLoginInfo(String loginInfo) {
    return null;
  }
}
