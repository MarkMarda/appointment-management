package com.marda.arch.hex.app_be_appointment_management.adapter.in.rest.controller;

import com.marda.arch.hex.app_be_appointment_management.adapter.in.rest.dtos.ScheduleDto;
import com.marda.arch.hex.app_be_appointment_management.application.exceptions.ScheduleApplicationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.marda.arch.hex.app_be_appointment_management.adapter.in.rest.constants.APIConstants.API_SCHEDULE_QUERY;

@RequestMapping(API_SCHEDULE_QUERY)
public interface ScheduleQueryController {
    //End-point
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleDto> findById(@PathVariable("id") Long id) throws ScheduleApplicationException;

    //OpenApi Specification (Swagger Docs)
}
