package org.mapleland.maplelanbackserver.exception;

public class UnauthorizedException extends RuntimeException {
    private static final String MESSAGE = "인증이 필요합니다.";

    public UnauthorizedException() {super(MESSAGE);}

    public UnauthorizedException(String message) {super(message);}
}
