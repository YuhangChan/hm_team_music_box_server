package org.sleepy.hmmusicbox.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonResponse<T> {
    /**
     * custom status code
     */
    private int code;
    /**
     * status message
     */
    private String msg;
    /**
     * data to be returned
     */
    private T data;


    /**
     * used to define http status code (not included in JSON response)
     */
    @JsonIgnore
    private int httpCode;

    public static <T> CommonResponse<T> success() {
        return success(null);
    }

    public static <T> CommonResponse<T> success(T data) {
        return success(data, 200);
    }

    public static <T> CommonResponse<T> success(int httpCode) {
        return success(null, httpCode);
    }

    public static <T> CommonResponse<T> success(T data, int httpCode) {
        return new CommonResponse<>(0, "success", data, httpCode);
    }

    public static <T> CommonResponse<T> error(ErrorType type) {
        return new CommonResponse<>(type.getCode(), type.getMessage(), null, type.getHttpCode());
    }

    public static <T> CommonResponse<T> error(ErrorType type, String msg) {
        return new CommonResponse<>(type.getCode(), msg, null, type.getHttpCode());
    }

    public static <T> CommonResponse<T> error(BizException exception) {
        return new CommonResponse<>(exception.getCode(), exception.getMessage(), null, exception.getHttpCode());
    }
}