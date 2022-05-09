package com.lc.blog.center.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @author: lucheng
 * @data: 2022/5/4 15:29
 * @version: 1.0
 */
@Getter
public enum StatusEnum {
    VALID("有效",1),
    INVALID("无效", 0),
    DELETED("已删除", 0),
    UNDELETED("未删除",1),
    RECOMMEND("置顶",1),
    NOT_RECOMMEND("不置顶",0),
    COUNT_ADD("数量新增", 1),
    COUNT_DELETE("数量减少",-1);
    ;

    private String desc;
    private Integer code;

    StatusEnum(String desc, Integer code) {
        this.desc = desc;
        this.code = code;
    }
}
