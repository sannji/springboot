package org.wg.util;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS(1, "success"), FAIL(0, "failed");
    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
