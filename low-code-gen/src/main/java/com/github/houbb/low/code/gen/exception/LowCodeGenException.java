package com.github.houbb.low.code.gen.exception;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class LowCodeGenException extends RuntimeException {

    public LowCodeGenException() {
    }

    public LowCodeGenException(String message) {
        super(message);
    }

    public LowCodeGenException(String message, Throwable cause) {
        super(message, cause);
    }

    public LowCodeGenException(Throwable cause) {
        super(cause);
    }

    public LowCodeGenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
