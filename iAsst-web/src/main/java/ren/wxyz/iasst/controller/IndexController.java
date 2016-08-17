/**
 * Copyright (C) 2001-2016 wxyz <hyhjwzx@126.com>
 * <p>
 * This program can be distributed under the terms of the GNU GPL Version 2.
 * See the file LICENSE.
 */
package ren.wxyz.iasst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 *
 * @auther wxyz
 * @since 0.1
 */
@Controller
public class IndexController {

  /**
   * 默认和index页映射方法
   *
   * @return view:index
   */
  @RequestMapping("/")
  public String index() {
    return "index";
  }
}
