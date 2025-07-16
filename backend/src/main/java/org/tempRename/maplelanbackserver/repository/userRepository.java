package org.mapleland.maplelanbackserver.repository;

import org.mapleland.maplelanbackserver.table.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepository extends JpaRepository<User, Integer> {

    /*
     * 반환값이 객체기 떄문에 Optional에 MapleJariUser 객체를 담는다.
     */
    Optional<User> findByDiscordId(String discordId);
    Optional<User> findByUserId(int userId);
}
