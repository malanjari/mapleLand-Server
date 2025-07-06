package org.mapleLand.maplelanbackserver.controller.errorController;


import software.amazon.awssdk.services.s3.endpoints.internal.Value;

public class NotFoundUserException extends RuntimeException{

    public NotFoundUserException(String message) {
        super(message);
    }
}
