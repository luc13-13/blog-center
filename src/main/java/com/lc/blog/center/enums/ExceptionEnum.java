package com.lc.blog.center.enums;

public enum ExceptionEnum {
    TOKEN_NOT_FOUND(8404, "请求无效"),
    AUTHENTICATION_FAILURE(8400, "认证失败");

    ExceptionEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer code;
    public String desc;

    @Override
    public String toString() {
        return "ExceptionEnum{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
