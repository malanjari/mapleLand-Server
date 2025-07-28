package org.mapleland.maplelanbackserver.repository;
import org.mapleland.maplelanbackserver.table.MapInterRest;
import org.mapleland.maplelanbackserver.table.User;
import org.mapleland.maplelanbackserver.table.MapleMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MapInterRestRepository extends JpaRepository<MapInterRest, Long> {



    List<MapInterRest> findByUser_UserId(int userId);

    long countByUser(User user);

    List<MapInterRest> findByMapleMap_MapleLandMapListId(int mapListId);


    boolean existsByMapleMap_MapleLandMapListIdAndUser_UserId(int mapleLandMapListEntityMapleLandMapListId,
                                                              int mapleJariUserEntityUserId);

    boolean existsByUser_UserIdAndMapleMap_MapleLandMapListId(Integer userUserId,
                                                              Integer mapleMapMapleLandMapListId);

    Optional<MapInterRest> findByUser_UserIdAndMapleMap_MapleLandMapListId(int mapleJariUserEntityUserId, int mapleLandMapListEntityMapleLandMapListId);

    @Query("""
        SELECT m.mapleMap.mapName 
        FROM MapInterRest m 
        WHERE m.user.discordId = :discordId
    """)
    List<String> findMapNamesByDiscordId(@Param("discordId") String discordId);

    Optional<MapInterRest> findByUser_UserIdAndMapleMap_MapName(Integer userUserId, String mapleMapMapName);

}




