package org.mapleLand.maplelanbackserver.repository;

import org.mapleLand.maplelanbackserver.table.MapleLandMapListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<MapleLandMapListEntity, Integer> {

}

