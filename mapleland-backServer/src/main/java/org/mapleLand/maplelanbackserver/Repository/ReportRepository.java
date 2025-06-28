package org.mapleLand.maplelanbackserver.Repository;

import org.mapleLand.maplelanbackserver.Table.MapleLandMapList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<MapleLandMapList, Integer> {

}

