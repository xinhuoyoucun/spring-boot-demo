package com.xkcoding.exception.handler.exception;

import com.xkcoding.exception.handler.constant.Status;
import lombok.Getter;

/**
 * <p>
 * JSON异常
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-10-02 21:18
 */
@Getter
public class TestException extends BaseException {

    public TestException(Status status) {
        super(status);
    }

    public TestException(Integer code, String message) {
        super(code, message);
    }
}
