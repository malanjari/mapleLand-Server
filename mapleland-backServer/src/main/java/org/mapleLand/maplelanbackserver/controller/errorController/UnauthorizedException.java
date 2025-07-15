package org.mapleLand.maplelanbackserver.controller.errorController;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
