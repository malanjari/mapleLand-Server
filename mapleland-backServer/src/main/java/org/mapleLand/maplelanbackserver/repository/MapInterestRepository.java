package org.mapleLand.maplelanbackserver.repository;

import org.mapleLand.maplelanbackserver.table.MapInterestEntity;
import org.mapleLand.maplelanbackserver.table.MapleJariUserEntity;
import org.mapleLand.maplelanbackserver.table.MapleLandMapListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MapInterestRepository extends JpaRepository<MapInterestEntity, Long> {



    List<MapInterestEntity> findByMapleJariUserEntity_UserId(int userId);

    long countByMapleJariUserEntity(MapleJariUserEntity mapleJariUserEntity);

    List<MapInterestEntity> findByMapleLandMapListEntity_MapleLandMapListId(int mapListId);

    boolean existsByMapleLandMapListEntityAndMapleJariUserEntity(MapleLandMapListEntity mapleLandMapListEntity,
                                                                 MapleJariUserEntity mapleJariUserEntity);


}
