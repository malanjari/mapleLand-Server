package org.mapleland.maplelanbackserver.dto;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;


public record BanUserRequest(int userId, String reason, int bannedHours) { }
