package org.mapleLand.maplelanbackserver.repository;

import org.mapleLand.maplelanbackserver.enumType.Region;
import org.mapleLand.maplelanbackserver.table.MapRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface UserMapRegisterRepository extends JpaRepository<MapRegistrationEntity, Integer> {

    @Query("""
    SELECT m.mapName AS mapName,
           MAX(m.area) AS area,
           MAX(m.monsterImageUrl) AS monsterImageUrl,
           COUNT(m) AS registerCount
    FROM MapRegistrationEntity m
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
    SELECT m FROM MapRegistrationEntity m
    WHERE m.createTime >= :oneWeekAgo
""")
    List<MapRegistrationEntity> findAllWithinOneWeek(@Param("oneWeekAgo") LocalDateTime oneWeekAgo);

    @Query("""
    SELECT m FROM MapRegistrationEntity m
    JOIN FETCH m.mapleJariUserEntity
    WHERE REPLACE(m.mapName, ' ', '') = REPLACE(:keyword, ' ', '')
    ORDER BY m.createTime DESC
""")
    List<MapRegistrationEntity> findByMapNameWithUser(@Param("keyword") String keyword);

    List<MapRegistrationEntity> findByArea(Region area);

}