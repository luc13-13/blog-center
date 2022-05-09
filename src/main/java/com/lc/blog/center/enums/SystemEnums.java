package com.lc.blog.center.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: lucheng
 * @data: 2022/5/4 16:53
 * @version: 1.0
 */
@Getter
@AllArgsConstructor
public enum SystemEnums {
    ADMIN_ID("管理员id",1000000000L),
    ADMIN_LOGIN_NAME("管理员登录名","lucheng");
    private String desc;
    private Object code;
}
