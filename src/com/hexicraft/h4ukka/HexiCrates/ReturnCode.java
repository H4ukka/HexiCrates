package com.hexicraft.h4ukka.HexiCrates;

/**
 * [name] [description] [isError]
 */

public enum ReturnCode {

    SUCCESS ("", false),
    UNSUPPORTED_SOURCE ("Who are you?", true),
    TOO_FEW_ARGUMENTS ("Not enough arguments.", true),
    UNKNOWN_COMMAND ("What command is this?", true),
    PACK_ERROR ("Unknown crate type", true);

    String errorDescription;
    boolean isError;

    private ReturnCode (String errorDescription, boolean isError) {
        this.errorDescription = errorDescription;
        this.isError = isError;
    }
}
