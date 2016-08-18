/**
 * Copyright (C) 2001-2016 wxyz <hyhjwzx@126.com>
 * <p>
 * This program can be distributed under the terms of the GNU GPL Version 2.
 * See the file LICENSE.
 */
package ren.wxyz.iasst.domain.persistent;

import lombok.Data;

/**
 * 系统用户
 *
 * @auther wxyz 2016-08-18_00:41
 * @since 0.1
 */
@Data
public class User extends BaseModel {

    private String username;

    private String password;

    private String passwordSalt;

    private Boolean enabled;

    private String token;

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
