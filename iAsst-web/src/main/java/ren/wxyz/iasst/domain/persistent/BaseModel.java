/**
 * Copyright (C) 2001-2016 wxyz <hyhjwzx@126.com>
 * <p>
 * This program can be distributed under the terms of the GNU GPL Version 2.
 * See the file LICENSE.
 */
package ren.wxyz.iasst.domain.persistent;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 基础持久化类
 *
 * @auther wxyz 2016-08-18_21:17
 * @since 0.1
 */
@Getter
@Setter
public abstract class BaseModel {
    /**
     * 主键
     */
    private Integer oid;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;
}
