package org.mapleland.maplelanbackserver.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mapleland.maplelanbackserver.dto.user.UserResponse;

import java.time.LocalDateTime;
import java.util.List;


public record UserListResponse(int userId,
                               String userName,
                               String discordId,
                               String role,
                               int reportedCount,
                               String image,
                               String globalName,
                               LocalDateTime createTime) { }
