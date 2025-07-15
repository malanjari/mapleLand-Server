package org.mapleLand.maplelanbackserver.enumType.alert;

public enum AlertStatus {
    ALERT_OFF("알람 제거"),
    ALERT_ON("알람등록 완료"),
    INVALID_REQUEST("잘못된 요청");

    final String message;


    AlertStatus(String message) {
        this.message = message;
    }
}
