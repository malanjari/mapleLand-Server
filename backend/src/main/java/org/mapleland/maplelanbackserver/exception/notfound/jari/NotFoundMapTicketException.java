package org.mapleland.maplelanbackserver.exception.notfound.jari;

import org.mapleland.maplelanbackserver.exception.notfound.NotFoundException;

public class NotFoundMapTicketException extends NotFoundException {

    private static final String MESSAGE = "티켓을 찾을 수 없습니다.";

    private NotFoundMapTicketException() {super(MESSAGE);}

    public NotFoundMapTicketException(String message) {
        super(message);
    }
}
