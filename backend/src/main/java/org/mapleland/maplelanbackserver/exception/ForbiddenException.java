package org.mapleland.maplelanbackserver.exception;

public class ForbiddenException extends RuntimeException{
    private static final String MESSAGE = "해당 리소스에 접근할 권한이 없습니다.";

    public ForbiddenException() {super(MESSAGE);}

    public ForbiddenException(String message) {super(message);}
}
