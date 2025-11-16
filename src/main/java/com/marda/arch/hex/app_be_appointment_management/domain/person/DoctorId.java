package com.marda.arch.hex.app_be_appointment_management.domain.person;

import com.marda.arch.hex.app_be_appointment_management.domain.exceptions.DomainExceptions;

import static java.util.Objects.isNull;

public class DoctorId {
    private Long value;

    public DoctorId(Long value) throws DomainExceptions {
        if (isNull(value) || value <= 0) {
            throw new DomainExceptions(String.format("Doctor id = %d is not valid", value));
        }
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}
