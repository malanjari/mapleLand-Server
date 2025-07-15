package org.mapleLand.maplelanbackserver.enumType.alert;

public enum AlertStatus {
    ALERT_OFF("알람 제거"),
    ALERT_ON("알람등록 완료"),
    NOT_LOGIN("비로그인 유저");

    final String message;


    AlertStatus(String message) {
        this.message = message;
    }
}
