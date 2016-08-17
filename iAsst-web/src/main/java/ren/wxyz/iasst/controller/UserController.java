/**
 * Copyright (C) 2001-2016 wxyz <hyhjwzx@126.com>
 * <p>
 * This program can be distributed under the terms of the GNU GPL Version 2.
 * See the file LICENSE.
 */
package ren.wxyz.iasst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ren.wxyz.iasst.domain.User;
import ren.wxyz.iasst.service.UserService;

/**
 * 用户相关流转
 *
 * @auther wxyz
 * @since 0.1
 */
@Controller("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping("/info")
  public User getUser(String email) {
    return userService.getUserByLoginInfo(email);
  }
}
