package org.mapleland.maplelanbackserver.exception.coflict;

public class CoolDownConflictException extends ConflictException{
    private static final String MESSAGE = "끌올은 한시간의 한번만 가능합니다.";

    public CoolDownConflictException(String message) {
        super(message);
    }
}
