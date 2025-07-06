package org.mapleLand.maplelanbackserver.controller.errorController;

public class NotFoundMapTicketException extends  RuntimeException{

    public NotFoundMapTicketException(String message) {
        super(message);
    }
}
