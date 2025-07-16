package org.mapleland.maplelanbackserver.exception;

import lombok.Getter;

@Getter
public class UserBanGlobalException extends RuntimeException{


    private final String reason;

    public UserBanGlobalException(String message, String reason) {
        super(message);
        this.reason = reason;
    }
}
