package com.marda.arch.hex.app_be_appointment_management.domain.base;

import com.marda.arch.hex.app_be_appointment_management.domain.exceptions.DomainExceptions;

@FunctionalInterface
public interface IsValid {
    boolean valid() throws DomainExceptions;
}
