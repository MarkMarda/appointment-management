package com.marda.arch.hex.app_be_appointment_management.adapter.in.rest.mappers;

import com.marda.arch.hex.app_be_appointment_management.adapter.in.rest.dtos.ScheduleDto;
import com.marda.arch.hex.app_be_appointment_management.domain.schedule.Schedule;

import java.util.List;

public interface ScheduleAdapterRestMapper {
    ScheduleDto toDto(Schedule schedule);
    List<ScheduleDto> toDto(List<Schedule> scheduleList);
}
