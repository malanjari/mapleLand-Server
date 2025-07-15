package org.mapleland.maplelanbackserver.repository;

import org.mapleland.maplelanbackserver.table.MonsterDropItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonsterDropItemRepository extends JpaRepository<MonsterDropItem,Integer> {
    @Query("""
    SELECT m FROM MonsterDropItem m
    WHERE REPLACE(m.mapName, ' ', '') = REPLACE(:mapName, ' ', '')
""")
    List<MonsterDropItem> findByMapName(String mapName);
}
