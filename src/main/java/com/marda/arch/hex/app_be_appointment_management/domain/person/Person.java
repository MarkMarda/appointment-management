package com.marda.arch.hex.app_be_appointment_management.domain.person;

import com.marda.arch.hex.app_be_appointment_management.domain.base.GenericDomain;
import com.marda.arch.hex.app_be_appointment_management.domain.exceptions.DomainExceptions;

public class Person extends GenericDomain {
    public Person(Long id) throws DomainExceptions {
        super(id);
    }

    @Override
    public boolean valid() throws DomainExceptions {
        return false;
    }
}
