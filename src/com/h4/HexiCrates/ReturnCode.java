package com.h4.HexiCrates;

public enum ReturnCode {

    SUCCESS (0),
    UNKNOWN_SOURCE (1),
    TOO_MANY_ARGUMENTS (2),
    UNKNOW_COMMAND (3);

    private int code;

    private ReturnCode (int code) {
        this.code = code;
    }
}
