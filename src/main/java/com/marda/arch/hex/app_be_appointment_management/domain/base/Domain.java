package com.marda.arch.hex.app_be_appointment_management.domain.base;

// All cases that we can find in others domains
public abstract class Domain implements IsValid {
    protected Long id;
    protected EstateEnum estate;

    public EstateEnum getEstate() {
        return estate;
    }

    public void setEstate(EstateEnum estate) {
        this.estate = estate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
