package org.mapleland.maplelanbackserver.exception.jari;

import org.mapleland.maplelanbackserver.exception.NotFoundException;

public class JariNotFoundException extends NotFoundException {
    private static String MESSAGE = "해당 자리거래를 찾을 수 없습니다.";

    public JariNotFoundException() {super(MESSAGE);}

    public JariNotFoundException(String message) {super(message);}
}
