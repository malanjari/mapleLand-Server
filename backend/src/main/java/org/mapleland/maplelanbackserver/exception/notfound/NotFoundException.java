package org.mapleland.maplelanbackserver.exception.notfound;

public class NotFoundException extends RuntimeException {
    private static final String MESSAGE = "리소스를 찾을 수 없습니다.";

    //기본 생성자
    public NotFoundException()
    {super(MESSAGE);}

    //메세지가 들어오면 이 생성자 호출
    public NotFoundException(String message)
    {super(message);}
}
