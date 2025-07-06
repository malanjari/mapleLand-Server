package org.mapleLand.maplelanbackserver.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class BannedDto {

    private String discordId;
    private String banReason;
}
