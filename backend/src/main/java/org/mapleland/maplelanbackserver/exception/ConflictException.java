package org.mapleland.maplelanbackserver.exception;

public class ConflictException extends RuntimeException{
    private static final String MESSAGE = "현재 리소스의 상태와 충돌합니다.";

    public ConflictException() {super(MESSAGE);}

    public ConflictException(String message) {super(message);}
}

