package com.h4.HexiCrates;

public enum ReturnCode {

    SUCCESS (0),
    UNKNOWN_SOURCE (1),
    TOO_FEW_ARGUMENTS (2),
    UNKNOWN_COMMAND (3);

    private int code;

    private ReturnCode (int code) {
        this.code = code;
    }

    public int getCode () {
        return code;
    }
}
