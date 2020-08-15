package org.wg.util;

import lombok.Builder;
import lombok.Data;
import static org.wg.util.ResponseCode.*;

@Data
@Builder
public class ApiResponse {
    private int code;
    private String msg;
    private Object data;

    /**
     * 底层调用方法
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static ApiResponse create(final int code, final String msg, final Object data) {
        return ApiResponse.builder().code(code).msg(msg).data(data).build();
    }

    /**
     * 成功返回方法
     * @param data
     * @return
     */
    public static ApiResponse createSuccess(Object data) {
        return create(SUCCESS.getCode(), SUCCESS.getMsg(), data);
    }

    /**
     * 错误返回
     * @param msg
     * @return
     */
    public static ApiResponse createFail(String msg) {return create(FAIL.getCode(), msg, null);}
}
