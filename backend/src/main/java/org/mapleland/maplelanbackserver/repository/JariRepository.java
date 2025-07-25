package org.mapleland.maplelanbackserver.repository;

import org.apache.tomcat.Jar;
import org.mapleland.maplelanbackserver.dto.response.ResponseWebSocketPostDto;
import org.mapleland.maplelanbackserver.enumType.Region;
import org.mapleland.maplelanbackserver.enumType.TradeType;
import org.mapleland.maplelanbackserver.table.Jari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Repository
public interface JariRepository extends JpaRepository<Jari, Integer> {



    @Query("""
    SELECT m.mapName AS mapName,
           MAX(m.area) AS area,
           MAX(m.monsterImageUrl) AS monsterImageUrl,
           COUNT(m) AS registerCount
    FROM Jari m
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
    SELECT m FROM Jari m
    WHERE m.createTime >= :oneWeekAgo
""")
    List<Jari> findAllWithinOneWeek(@Param("oneWeekAgo") LocalDateTime oneWeekAgo);

    @Query("""
    SELECT m FROM Jari m
    JOIN FETCH m.user
    WHERE REPLACE(m.mapName, ' ', '') = REPLACE(:keyword, ' ', '')
    ORDER BY m.createTime DESC
""")
    List<Jari> findTop100ByMapNameWithUser(@Param("keyword") String keyword, Pageable pageable);

    List<Jari> findByArea(Region area);


    @Query("""
    SELECT m FROM Jari m
    WHERE m.user.userId = :userId
    ORDER BY m.createTime DESC
""")
    List<Jari> findByMapleJariUserEntity_UserId(@Param("userId") Integer userId);

    @Query("""
    SELECT m FROM Jari m
    WHERE m.mapName = :mapName
    AND m.isCompleted = true
    AND m.createTime BETWEEN :start AND :end
""")
    List<Jari> findCompletedByMapNameIgnoreSpaceAndDate(
            @Param("mapName") String mapName,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );
    @Query("SELECT m FROM Jari m WHERE m.userMapId = :userMapId")
    Jari findByUserMapId(@Param("userMapId") int mapId);

    @Query("SELECT m FROM Jari m WHERE m.userMapId = :userMapId")
    Optional<Jari> OPTIONALFindByUserMapId(@Param("userMapId") int userMapId);

    @Query("""
        SELECT j
        FROM Jari j
        JOIN Report r ON r.jari = j
        GROUP BY j
        HAVING COUNT(r) > 0
    """)
    List<Jari> findReportedPosts(Pageable pageable);

    @Query("""
    SELECT COUNT(DISTINCT j)
    FROM Jari j
    JOIN Report r ON r.jari = j
""")
    long countReportedJari();


    @Query("""
SELECT new org.mapleland.maplelanbackserver.dto.response.ResponseWebSocketPostDto(
  j.user.userName,
  j.mapName,
  j.createTime
)
FROM Jari j ORDER BY j.createTime desc
""")
    List<ResponseWebSocketPostDto> findLatestPost(Pageable pageable);

    Optional<Jari> findByMapNameAndUserMapId(String mapName, Integer userMapId);

    Optional<Jari> findByUser_UserIdAndMapNameAndIsCompletedFalse(Integer userId, String mapName);

    Optional<Jari> findByUser_UserIdAndTradeTypeAndUserMapId(Integer userUserId, TradeType tradeType, Integer userMapId);

    Optional<Jari> findByUser_UserIdAndUserMapId(Integer userId, Integer mapId);



}
