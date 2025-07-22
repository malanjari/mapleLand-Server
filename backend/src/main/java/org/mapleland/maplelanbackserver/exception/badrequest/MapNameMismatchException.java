package org.mapleland.maplelanbackserver.exception.badrequest;

public class MapNameMismatchException extends BadRequestException{
    private static final String MESSAGE = "맵 이름이 일치 하지 않습니다.";

    MapNameMismatchException(){
        super(MESSAGE);
    }

    public MapNameMismatchException(String message) {
        super(message);
    }
}
