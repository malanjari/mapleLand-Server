package org.mapleLand.maplelanbackserver.repository;

import org.mapleLand.maplelanbackserver.table.MapInterestEntity;
import org.mapleLand.maplelanbackserver.table.MapleJariUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MapInterestRepository extends JpaRepository<MapInterestEntity, Long> {
    @Query("""
SELECT i FROM MapInterestEntity i 
WHERE REPLACE(i.mapName, ' ', '') = REPLACE(:mapName, ' ', '')
""")
    List<MapInterestEntity> findAllByMapName(String mapName);
    Optional<MapleJariUserEntity> findByMapleJariUserEntity_UserId(int userId);
    boolean existsByMapNameAndMapleJariUserEntity(String mapName, MapleJariUserEntity user);

    long countByMapleJariUserEntity(MapleJariUserEntity mapleJariUserEntity);


}
