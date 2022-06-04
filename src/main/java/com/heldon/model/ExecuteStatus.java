package com.heldon.model;

public enum ExecuteStatus {

    SUCCESS(0, "成功"),
    UN_AUTHENTICATION(400, "需要认证"),
    AUTHENTICATION_FAILED(401, "认证失败"),
    ACCESS_DENIED(403, "拒绝访问"),
    TOKEN_INVALID(404, "token校验失败"),
    SUBJECT_LIMITED(405, "身份受限定"),
    TOKEN_EXPIRED(406, "token过期"),
    SUBJECT_NOT_FOUND(407, "账户不存在"),
    AUTHORIZE_NOT_ALLOW(441, "非法授权操作"),

    SERVER_ERROR(500, "服务异常"),
    EXTERNAL_SERVICE_ERROR(555, "外部服务异常"),
    REQUEST_ERROR(911, "错误的请求"),

    PARAMETER_ERROR(1001, "参数错误"),
    DUPLICATE_ERROR(1002, "资源重复"),
    ;

    public final Integer code;
    public final String title;

    ExecuteStatus(Integer code, String title) {
        this.code = code;
        this.title = title;
    }
}
