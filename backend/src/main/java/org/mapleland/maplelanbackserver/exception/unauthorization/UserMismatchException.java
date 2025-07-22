package org.mapleland.maplelanbackserver.exception.unauthorization;

public class UserMismatchException extends UnauthorizedException{
    private static final String MESSAGE = "사용자가 다릅니다.";
    public
    UserMismatchException(String msg) {
        super(msg);
    }
}
