package org.mapleland.maplelanbackserver.exception.notfound.jari;

import org.mapleland.maplelanbackserver.exception.notfound.NotFoundException;

public class NotFoundMapException extends NotFoundException {
    private static String MESSAGE = "맵을 찾을 수 없습니다.";

    public NotFoundMapException() {
        super(MESSAGE);
    }

   public NotFoundMapException(String message) {
        super(message);
    }
}
