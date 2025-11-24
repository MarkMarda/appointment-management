package com.marda.arch.hex.app_be_appointment_management.adapter.in.rest.controller;

import com.marda.arch.hex.app_be_appointment_management.adapter.in.rest.dtos.ScheduleDto;
import com.marda.arch.hex.app_be_appointment_management.adapter.in.rest.mappers.ScheduleAdapterRestMapper;
import com.marda.arch.hex.app_be_appointment_management.application.exceptions.ScheduleApplicationException;
import com.marda.arch.hex.app_be_appointment_management.application.ports.in.schedule.ScheduleQueryFindByIdUseCase;
import com.marda.arch.hex.app_be_appointment_management.domain.schedule.Schedule;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ScheduleQueryControllerImpl extends GenericControllerImpl implements ScheduleQueryController {
    private final ScheduleQueryFindByIdUseCase scheduleQueryFindByIdUseCase;

    private final ScheduleAdapterRestMapper scheduleAdapterRestMapper;

    public ScheduleQueryControllerImpl(ScheduleQueryFindByIdUseCase scheduleQueryFindByIdUseCase, ScheduleAdapterRestMapper scheduleAdapterRestMapper) {
        this.scheduleQueryFindByIdUseCase = scheduleQueryFindByIdUseCase;
        this.scheduleAdapterRestMapper = scheduleAdapterRestMapper;
    }


    @Override
    public ResponseEntity<ScheduleDto> findById(Long id) throws ScheduleApplicationException {
        Optional<Schedule> scheduleOpt = scheduleQueryFindByIdUseCase.findById(id);

        if (scheduleOpt.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(scheduleAdapterRestMapper.toDto(scheduleOpt.get()));
    }
}
