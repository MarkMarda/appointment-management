package com.marda.arch.hex.app_be_appointment_management.application.services;

import com.marda.arch.hex.app_be_appointment_management.application.exceptions.ScheduleApplicationException;
import com.marda.arch.hex.app_be_appointment_management.application.ports.in.schedule.ScheduleQueryFindByIdUseCase;
import com.marda.arch.hex.app_be_appointment_management.application.ports.in.schedule.ScheduleQueryFindBySpecialityUseCase;
import com.marda.arch.hex.app_be_appointment_management.application.ports.out.schedule.ScheduleQueryFindByIDPort;
import com.marda.arch.hex.app_be_appointment_management.application.ports.out.schedule.ScheduleQueryFindBySpecialityPort;
import com.marda.arch.hex.app_be_appointment_management.domain.schedule.Schedule;

import java.util.List;
import java.util.Optional;

public class ScheduleQueryService implements ScheduleQueryFindByIdUseCase, ScheduleQueryFindBySpecialityUseCase {
    private final ScheduleQueryFindByIDPort scheduleQueryFindByIDPort;
    private final ScheduleQueryFindBySpecialityPort scheduleQueryFindBySpecialityPort;

    public ScheduleQueryService(
            ScheduleQueryFindByIDPort scheduleQueryFindByIDPort,
            ScheduleQueryFindBySpecialityPort scheduleQueryFindBySpecialityPort
    ) {
        this.scheduleQueryFindByIDPort = scheduleQueryFindByIDPort;
        this.scheduleQueryFindBySpecialityPort = scheduleQueryFindBySpecialityPort;
    }

    @Override
    public Optional<Schedule> findById(Long id) throws ScheduleApplicationException {
        return scheduleQueryFindByIDPort.findById(id);
    }

    //Example if it is needed
    @Override
    public List<Schedule> findBySpeciality(Long specialityId) throws ScheduleApplicationException {
        return scheduleQueryFindBySpecialityPort.findBySpeciality(specialityId);
    }
}
