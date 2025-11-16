package com.marda.arch.hex.app_be_appointment_management.domain.person;

public class Doctor extends Person {
    private DoctorStateEnum doctorState;

    public DoctorStateEnum getDoctorState() {
        return doctorState;
    }
}
