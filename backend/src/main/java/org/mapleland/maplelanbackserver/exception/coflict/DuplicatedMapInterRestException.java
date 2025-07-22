package org.mapleland.maplelanbackserver.exception.coflict;

public class DuplicatedMapInterRestException extends ConflictException {
    private static final String MESSAGE = "이미 등록된 관심 맵입니다.";

    DuplicatedMapInterRestException(){
        super(MESSAGE);
    }

   public DuplicatedMapInterRestException(String message) {
        super(message);
    }
}
