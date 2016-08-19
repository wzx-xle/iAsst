/**
 * Copyright (C) 2001-2016 wxyz <hyhjwzx@126.com>
 * <p>
 * This program can be distributed under the terms of the GNU GPL Version 2.
 * See the file LICENSE.
 */
package ren.wxyz.iasst.helper.bean;

/**
 * 异常类型
 *
 * @auther wxyz 2016-08-19_08:23
 * @since 0.1
 */
public enum ExceptionType {

    PARAMETER_ELLEGAL(403, "参数错误"),
    DATA_NOT_FOUND(404, "数据未找到"),

    AUTHORIZATION_ERROR(401, "请先登录"),
    USER_NOT_FOUND(602, "用户不存在"),
    USERNAME_PASSWORD_ERROR(602, "用户名或密码错误")
    ;

    private int code;

    private String message;

    ExceptionType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
