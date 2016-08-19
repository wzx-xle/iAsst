/**
 * Copyright (C) 2001-2016 wxyz <hyhjwzx@126.com>
 * <p>
 * This program can be distributed under the terms of the GNU GPL Version 2.
 * See the file LICENSE.
 */
package ren.wxyz.iasst.exception;

import ren.wxyz.iasst.helper.bean.ExceptionType;

/**
 * 业务异常
 *
 * @auther wxyz 2016-08-18_22:05
 * @since 0.1
 */
public class BusinessException extends RuntimeException {

    private int code;

    public BusinessException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.code = exceptionType.getCode();
    }

    public int getCode() {
        return this.code;
    }
}
