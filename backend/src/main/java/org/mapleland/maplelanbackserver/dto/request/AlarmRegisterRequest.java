package org.mapleland.maplelanbackserver.dto.request;

import software.amazon.awssdk.services.s3.endpoints.internal.Value;

public record AlarmRegisterRequest(String discordId , String mapName) {
}
