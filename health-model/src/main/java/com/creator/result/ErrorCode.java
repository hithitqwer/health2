package com.creator.result;

public enum ErrorCode {
    Ok(200),
    ParameterError(400),
    NoPermission(403),
    NotLogin(401),
    DuplicateSubmit(402),
    InternalError(500),
    SmsError(501),
    ErrorWhileExpire(700);
    private int value;

    ErrorCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
