package org.mapleLand.maplelanbackserver.controller.errorController;

public class NotFoundMapException extends RuntimeException {

   public NotFoundMapException(String message) {
        super(message);
    }
}
