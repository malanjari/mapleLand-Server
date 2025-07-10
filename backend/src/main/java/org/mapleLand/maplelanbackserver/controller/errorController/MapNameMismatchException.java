package org.mapleLand.maplelanbackserver.controller.errorController;

public class MapNameMismatchException extends RuntimeException{

    public MapNameMismatchException(String message) {
        super(message);
    }
}
