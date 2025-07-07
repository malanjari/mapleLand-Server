package org.mapleLand.maplelanbackserver.repository;
import org.mapleLand.maplelanbackserver.enumType.Region;
import org.mapleLand.maplelanbackserver.table.MapleLandMapListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MapleLandMapListRepository extends JpaRepository<MapleLandMapListEntity, Integer> {

    //검색용

    @Query("SELECT m FROM MapleLandMapListEntity m WHERE REPLACE(m.mapName, ' ', '') LIKE CONCAT('%', REPLACE(:keyword, ' ', ''), '%')")
    List<MapleLandMapListEntity> findByMapName(@Param("keyword") String keyword);

    // 정확 일치 (신규 추가)
    @Query("SELECT m FROM MapleLandMapListEntity m WHERE REPLACE(m.mapName, ' ', '') = REPLACE(:keyword, ' ', '')")
    List<MapleLandMapListEntity> findByMapNameExact(@Param("keyword") String keyword);

    List<MapleLandMapListEntity> findByRegion(Region region);

}
