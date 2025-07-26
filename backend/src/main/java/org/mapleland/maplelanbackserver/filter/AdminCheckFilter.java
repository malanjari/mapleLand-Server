package org.mapleland.maplelanbackserver.filter;

public class AdminCheckFilter {


    public static String adminCheckFilter(String discordId) {


        if (discordId.equals("821213405360029698") || discordId.equals("1147804753691148318") ||
                discordId.equals("272022728955920384") || discordId.equals("423159863141728256") ||
                discordId.equals("323827890150047744" || discordId.equals("1202998458139803698"))) {

            return "ROLE_ADMIN";
        }
        return "ROLE_USER";
    }
}
