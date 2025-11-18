package com.marda.arch.hex.app_be_appointment_management.domain.person;

import com.marda.arch.hex.app_be_appointment_management.domain.exceptions.DomainExceptions;

public class Doctor extends Person {
    private DoctorStateEnum doctorState;

    public Doctor(Long id) throws DomainExceptions {
        super(id);
    }

    public DoctorStateEnum getDoctorState() {
        return doctorState;
    }
}
