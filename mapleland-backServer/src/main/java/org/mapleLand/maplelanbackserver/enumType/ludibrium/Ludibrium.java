package org.mapleLand.maplelanbackserver.enumType.ludibrium;

import lombok.Getter;

@Getter
public enum Ludibrium {
    Path_of_Time_1("루디브리엄성:시간의길<1>"),
    Path_of_Time_2("루디브리엄성:시간의길<2>"),
    Path_of_Time_3("루디브리엄성:시간의길<3>"),
    Path_of_Time_4("루디브리엄성:시간의길<4>"),
    Twisted_Path_of_Time_1("시계탑최하층:뒤틀린 시간의 길<1>"),
    Twisted_Path_of_Time_2("시계탑최하층:뒤틀린 시간의 길<2>"),
    Twisted_Path_of_Time_3("시계탑최하층:뒤틀린 시간의 길<3>"),
    Twisted_Path_of_Time_4("시계탑최하층:뒤틀린 시간의 길<4>"),
    Forbidden_Time("시계탑최하층:금지된 시간"),
    Lost_Time("시계탑최하층:사라진 시간"),
    Twisted_Time("시계탑최하층:삐뚤어진 시간"),
    TWISTED_TIME("시계탑최하층:꼬여버린 시간");


    private static String normalize(String displayName) {
        return displayName.replaceAll("\\s+","");

    }

    private final String displayName;

    Ludibrium(String displayName) {
        this.displayName = displayName;
    }


}
