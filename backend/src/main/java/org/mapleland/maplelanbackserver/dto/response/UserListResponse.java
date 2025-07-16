package org.mapleland.maplelanbackserver.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mapleland.maplelanbackserver.dto.user.UserResponse;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserListResponse {
    private List<UserResponse> userList;
}
