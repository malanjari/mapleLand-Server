package org.mapleland.maplelanbackserver.exception.notfound.jari;


public class NotFoundUserException extends RuntimeException{
    private final static String MESSAGE = "사용자를 찾을 수 없습니다.";

    NotFoundUserException(){
        super(MESSAGE);
    }

    public NotFoundUserException(String message) {
        super(message);
    }
}
