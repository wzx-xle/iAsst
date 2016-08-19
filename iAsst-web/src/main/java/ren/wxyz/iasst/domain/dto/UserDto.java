/**
 * Copyright (C) 2001-2016 wxyz <hyhjwzx@126.com>
 * <p>
 * This program can be distributed under the terms of the GNU GPL Version 2.
 * See the file LICENSE.
 */
package ren.wxyz.iasst.domain.dto;

import lombok.Data;

import java.util.Date;

/**
 * 用户Dto
 *
 * @auther wxyz 2016-08-19_08:57
 * @since 0.1
 */
@Data
public class UserDto {

    private Integer oid;

    private Date createdTime;

    private Date updatedTime;

    private String username;
}
