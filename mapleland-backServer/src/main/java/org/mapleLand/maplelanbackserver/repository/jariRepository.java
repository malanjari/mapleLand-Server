package org.mapleland.maplelanbackserver.repository;

import org.mapleland.maplelanbackserver.enumType.Region;
import org.mapleland.maplelanbackserver.table.jari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface jariRepository extends JpaRepository<jari, Integer> {

    @Query("""
    SELECT m.mapName AS mapName,
           MAX(m.area) AS area,
           MAX(m.monsterImageUrl) AS monsterImageUrl,
           COUNT(m) AS registerCount
    FROM jari m
    WHERE m.createTime >= :oneWeekAgo
    GROUP BY m.mapName
    ORDER BY registerCount DESC
""")
    List<MapPopularityProjection> findTopPopularMaps(
            @Param("oneWeekAgo") LocalDateTime oneWeekAgo,
            Pageable pageable
    );

    interface MapPopularityProjection {
        String getMapName();

        int getRegisterCount();

        String getArea(); // Enum의 name()이 문자열로 바인딩됨

        String getMonsterImageUrl();
    }

    @Query("""
    SELECT m FROM jari m
    WHERE m.createTime >= :oneWeekAgo
""")
    List<jari> findAllWithinOneWeek(@Param("oneWeekAgo") LocalDateTime oneWeekAgo);

    @Query("""
    SELECT m FROM jari m
    JOIN FETCH m.user
    WHERE REPLACE(m.mapName, ' ', '') = REPLACE(:keyword, ' ', '')
    ORDER BY m.createTime DESC
""")
    List<jari> findTop100ByMapNameWithUser(@Param("keyword") String keyword, Pageable pageable);

    List<jari> findByArea(Region area);


    @Query("""
    SELECT m FROM jari m
    WHERE m.user.userId = :userId
    ORDER BY m.createTime DESC
""")
    List<jari> findByMapleJariUserEntity_UserId(@Param("userId") Integer userId);

    @Query("""
    SELECT m FROM jari m
    WHERE REPLACE(m.mapName, ' ', '') = REPLACE(:mapName, ' ', '')
    AND m.isCompleted = true
    AND m.createTime BETWEEN :start AND :end
""")
    List<jari> findCompletedByMapNameIgnoreSpaceAndDate(
            @Param("mapName") String mapName,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );
    @Query("SELECT m FROM jari m WHERE m.userMapId = :userMapId")
    jari findByUserMapId(@Param("userMapId") int mapId);
}
