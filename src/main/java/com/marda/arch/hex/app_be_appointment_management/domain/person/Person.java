package com.marda.arch.hex.app_be_appointment_management.domain.person;

import com.marda.arch.hex.app_be_appointment_management.domain.base.Domain;
import com.marda.arch.hex.app_be_appointment_management.domain.exceptions.DomainExceptions;

public class Person extends Domain {
    @Override
    public boolean valid() throws DomainExceptions {
        return false;
    }
}
