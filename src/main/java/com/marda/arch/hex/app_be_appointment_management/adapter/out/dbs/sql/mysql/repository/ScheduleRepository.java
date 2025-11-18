package com.marda.arch.hex.app_be_appointment_management.adapter.out.dbs.sql.mysql.repository;

import com.marda.arch.hex.app_be_appointment_management.adapter.out.dbs.sql.mysql.entities.ScheduleEntity;
import com.marda.arch.hex.app_be_appointment_management.adapter.out.dbs.sql.mysql.repository.base.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends GenericRepository<ScheduleEntity, Long> {
    // JPQL
    // SQL
    // Projections
    // ...
}

