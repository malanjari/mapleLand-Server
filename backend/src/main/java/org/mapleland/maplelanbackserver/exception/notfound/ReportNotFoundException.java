package org.mapleland.maplelanbackserver.exception.notfound;

public class ReportNotFoundException extends NotFoundException {
    private static final String MESSAGE = "해당 신고를 찾을 수 없습니다.";

    public ReportNotFoundException() {super(MESSAGE);}

    public ReportNotFoundException(String message) {super(message);}
}
