package com.heldon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.heldon.utils.EqualsUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 响应主体
 *
 * @author hcl
 * @param <T>
 */
@ToString
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 2162329628803810530L;

    @Getter
    @Setter
    private int status;

    @Getter
    @Setter
    private String timestamp;

    @Getter
    @Setter
    private String error;

    /**
     * 业务补充说明(主要是开发阶段用)
     */
    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String path;

    @Getter
    @Setter
    private T data;


    public static <T> Response<T> ok() {

        return Response.of(ExecuteStatus.SUCCESS);
    }

    public static <T> Response<T> ok(T data) {
        return Response.<T>of(ExecuteStatus.SUCCESS).setData(data);
    }

    public static <T> Response<T> okMsg(String message) {
        return Response.<T>of(ExecuteStatus.SUCCESS).setDescription(message);
    }

    public static <T> Response<T> of(ExecuteStatus status) {
        boolean success = EqualsUtil.eq(status, ExecuteStatus.SUCCESS);
        return restResult(null, status.code, success ? null : status.title, null);
    }

    private static <T> Response<T> restResult(T data, int code, String title, String desc) {
        Response<T> apiResult = new Response<>();
        apiResult.setStatus(code);
        apiResult.setData(data);
        apiResult.setError(title);
        apiResult.setDescription(desc);
        return apiResult;
    }
}
