package com.marda.arch.hex.app_be_appointment_management.domain.schedule;

public enum ScheduleStateEnum {
    AVAILABLE(1, "Available"),
    RESERVED(2, "Reserved"),
    LOCKED(3, "Locked"),
    ;

    private Integer value;
    private String description;

    ScheduleStateEnum(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
