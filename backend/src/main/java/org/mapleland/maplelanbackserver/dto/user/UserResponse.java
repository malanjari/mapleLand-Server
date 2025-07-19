package org.mapleland.maplelanbackserver.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mapleland.maplelanbackserver.table.User;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserResponse {
    String discordId;

    String image;

    LocalDateTime createTime;

    String globalName;

    Boolean mapTicket;

    String userName;

    String email;

    int reportCount;

    public static UserResponse from(User user) {
        return new UserResponse(
                user.getDiscordId(),
                user.getImage(),
                user.getCreateTime(),
                user.getGlobalName(),
                user.getMapTicket(),
                user.getUserName(),
                user.getEmail(),
                user.getUserId()
        );
    }
}
