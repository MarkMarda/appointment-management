package com.marda.arch.hex.app_be_appointment_management.configuration.mysql;

import com.marda.arch.hex.app_be_appointment_management.application.ports.out.schedule.ScheduleQueryFindByIDPort;
import com.marda.arch.hex.app_be_appointment_management.application.ports.out.schedule.ScheduleQueryFindBySpecialityPort;
import com.marda.arch.hex.app_be_appointment_management.application.services.ScheduleQueryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScheduleMySQLConfig {
    // Application - Service
    @Bean
    ScheduleQueryService scheduleQueryService(
            ScheduleQueryFindByIDPort scheduleQueryFindByIDPort,
            ScheduleQueryFindBySpecialityPort scheduleQueryFindBySpecialityPort
    ) {
        return new ScheduleQueryService(scheduleQueryFindByIDPort, scheduleQueryFindBySpecialityPort);
    }

    // Adapters

    // Mappers
}
