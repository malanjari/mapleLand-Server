package org.mapleland.maplelanbackserver.exception.coflict;

public class DuplicateReportException extends ConflictException {
    private static final String MESSAGE = "신고는 중복될 수 없습니다.";

    public DuplicateReportException() {super(MESSAGE);}

    public DuplicateReportException(String message) {super(message);}
}
