package org.mapleland.maplelanbackserver.repository;
import org.mapleland.maplelanbackserver.enumType.Region;
import org.mapleland.maplelanbackserver.table.MapleMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MapleMapRepository extends JpaRepository<MapleMap, Integer> {

    //검색용

    @Query("SELECT m FROM MapleMap m WHERE REPLACE(m.mapName, ' ', '') LIKE CONCAT('%', REPLACE(:keyword, ' ', ''), '%')")
    List<MapleMap> findByMapName(@Param("keyword") String keyword);

    // 정확 일치 (신규 추가)
    @Query("SELECT m FROM MapleMap m WHERE REPLACE(m.mapName, ' ', '') = REPLACE(:keyword, ' ', '')")
    List<MapleMap> findByMapNameExact(@Param("keyword") String keyword);

    List<MapleMap> findByRegion(Region region);

    Optional<MapleMap> findById(Integer integer);

    boolean existsByRegion(Region region);

}
