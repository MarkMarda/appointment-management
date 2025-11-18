package com.marda.arch.hex.app_be_appointment_management.application.ports.in.schedule;

import com.marda.arch.hex.app_be_appointment_management.application.exceptions.ScheduleApplicationException;
import com.marda.arch.hex.app_be_appointment_management.domain.schedule.Schedule;

import java.util.List;

@FunctionalInterface
public interface ScheduleQueryFindBySpecialityUseCase {
    List<Schedule> findBySpeciality(Long specialityId) throws ScheduleApplicationException;
}
