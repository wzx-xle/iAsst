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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ren.wxyz.iasst.domain.dto.UserDto;
import ren.wxyz.iasst.domain.persistent.User;
import ren.wxyz.iasst.service.UserService;

/**
 * 用户相关流转
 *
 * @auther wxyz 2016-08-18_00:41
 * @since 0.1
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "user/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public UserDto checkLogin(String username, String password) {
        User user = userService.login(username, password);

        UserDto userDto = new UserDto();
        userDto.setOid(user.getOid());
        userDto.setCreatedTime(user.getCreatedTime());
        userDto.setUpdatedTime(user.getUpdatedTime());
        userDto.setUsername(user.getUsername());

        return userDto;
    }
}
