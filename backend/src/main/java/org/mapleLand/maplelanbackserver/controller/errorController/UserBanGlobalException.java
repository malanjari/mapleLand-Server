package org.mapleLand.maplelanbackserver.controller.errorController;

import lombok.Getter;

@Getter
public class UserBanGlobalException extends RuntimeException{


    private final String reason;

    public UserBanGlobalException(String message, String reason) {
        super(message);
        this.reason = reason;
    }
}
