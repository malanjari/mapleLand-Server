package org.mapleLand.maplelanbackserver.controller.errorController;

public class MaxMapInterestLimitException extends RuntimeException {

    public MaxMapInterestLimitException(String msg) {
        super(msg);
    }
}
