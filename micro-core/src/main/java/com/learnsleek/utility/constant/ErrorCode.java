package com.learnsleek.utility.constant;

public enum ErrorCode {
    BUSINESS_LOGIC_EXCEPTION (10000),
    DATABASE_LEVEL_EXCEPTION (20000),
    OTHER_EXCEPTION (3000);

    private final int errorCode;

    ErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public  int getErrorCode() {
        return errorCode;
    }
}
