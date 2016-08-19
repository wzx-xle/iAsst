/**
 * Copyright (C) 2001-2016 wxyz <hyhjwzx@126.com>
 * <p>
 * This program can be distributed under the terms of the GNU GPL Version 2.
 * See the file LICENSE.
 */
package ren.wxyz.iasst.helper.bean;

import lombok.Data;
import ren.wxyz.iasst.exception.BusinessException;

/**
 * 统一的回复
 *
 * @auther wxyz 2016-08-19_08:36
 * @since 0.1
 */
@Data
public class UnifiedResponse {
    private int code;
    private String message;
    private Object data;

    public UnifiedResponse(Exception exception) {
        if (exception instanceof BusinessException) {
            BusinessException businessException = (BusinessException) exception;
            this.code = businessException.getCode();
            this.message = businessException.getMessage();
        }
        else {
            this.code = 500;
            this.message = "系统发生错误，请联系管理员";
        }
    }

    public UnifiedResponse(Object data) {
        this.code = 200;
        this.message = "请求成功";
        this.data = data;
    }
}
