package com.h4.HexiCrates;

public enum ReturnCode {

    SUCCESS (""),
    UNSUPPORTED_SOURCE ("Who are you?"),
    TOO_FEW_ARGUMENTS ("Not enough arguments."),
    UNKNOWN_COMMAND ("What command is this?"),
    PACK_ERROR ("Unknown crate type");

    String errorDescription;

    private ReturnCode (String errorDescription) { this.errorDescription = errorDescription; }
}
