package com.marda.arch.hex.app_be_appointment_management.adapter.out.dbs.sql.mysql.adapters;

import com.marda.arch.hex.app_be_appointment_management.adapter.out.dbs.sql.exceptions.ScheduleAdapterDBException;
import com.marda.arch.hex.app_be_appointment_management.adapter.out.dbs.sql.mysql.entities.ScheduleEntity;
import com.marda.arch.hex.app_be_appointment_management.adapter.out.dbs.sql.mysql.mappers.ScheduleAdapterDBMapper;
import com.marda.arch.hex.app_be_appointment_management.adapter.out.dbs.sql.mysql.repository.ScheduleRepository;
import com.marda.arch.hex.app_be_appointment_management.application.exceptions.ScheduleApplicationException;
import com.marda.arch.hex.app_be_appointment_management.application.ports.out.schedule.ScheduleQueryFindByIDPort;
import com.marda.arch.hex.app_be_appointment_management.application.ports.out.schedule.ScheduleQueryFindBySpecialityPort;
import com.marda.arch.hex.app_be_appointment_management.domain.schedule.Schedule;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScheduleMySQLDBAdapter implements ScheduleQueryFindByIDPort, ScheduleQueryFindBySpecialityPort {
    private final ScheduleRepository scheduleRepository;

    private final ScheduleAdapterDBMapper scheduleAdapterDBMapper;

    private final String MSG_NOT_EXISTS = "Does not exits schedule with id=%d";

    public ScheduleMySQLDBAdapter(
            ScheduleRepository scheduleRepository,
            ScheduleAdapterDBMapper scheduleAdapterDBMapper
    ) {
        this.scheduleRepository = scheduleRepository;
        this.scheduleAdapterDBMapper = scheduleAdapterDBMapper;
    }

    @Override
    public Optional<Schedule> findById(Long id) throws ScheduleApplicationException {
        String mgsErr = String.format(MSG_NOT_EXISTS, id);
        ScheduleEntity scheduleEntity = scheduleRepository.findById(id)
                .orElseThrow(() -> new ScheduleApplicationException(mgsErr));

        try {
            return Optional.ofNullable(scheduleAdapterDBMapper.toDomain(scheduleEntity));
        } catch (ScheduleAdapterDBException e) {
            throw new ScheduleApplicationException(e);
        }
    }

    @Override
    public List<Schedule> findBySpeciality(Long specialityId) throws ScheduleApplicationException {
        return List.of();
    }
}
