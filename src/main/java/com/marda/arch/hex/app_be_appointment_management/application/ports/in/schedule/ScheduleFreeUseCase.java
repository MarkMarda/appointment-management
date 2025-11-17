package com.marda.arch.hex.app_be_appointment_management.application.ports.in.schedule;

import com.marda.arch.hex.app_be_appointment_management.application.exceptions.ScheduleApplicationException;

public interface ScheduleFreeUseCase {
    void free(Long id) throws ScheduleApplicationException;
}
