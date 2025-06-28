package org.mapleLand.maplelanbackserver.Repository;

import org.mapleLand.maplelanbackserver.Table.MapleJariUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MapleJariUserRepository extends JpaRepository<MapleJariUser, Long> {

    /*
     * 반환값이 객체기 떄문에 Optional에 MapleJariUser 객체를 담는다.
     */
    Optional<MapleJariUser> findByDiscordId(String discordId);
}
