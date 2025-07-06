package org.mapleLand.maplelanbackserver.repository;

import org.mapleLand.maplelanbackserver.table.MapleJariUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;
import java.util.Optional;

public interface MapleJariUserRepository extends JpaRepository<MapleJariUserEntity, Integer> {

    /*
     * 반환값이 객체기 떄문에 Optional에 MapleJariUser 객체를 담는다.
     */
    Optional<MapleJariUserEntity> findByDiscordId(String discordId);
    Optional<MapleJariUserEntity> findByUserId(int userId);
}
