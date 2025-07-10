package org.mapleLand.maplelanbackserver.repository;

import org.mapleLand.maplelanbackserver.table.MapDropItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapDropItemRepository extends JpaRepository<MapDropItemEntity,Integer> {
    @Query("""
    SELECT m FROM MapDropItemEntity m
    WHERE REPLACE(m.mapName, ' ', '') = REPLACE(:mapName, ' ', '')
""")
    List<MapDropItemEntity> findByMapName(String mapName);
}
