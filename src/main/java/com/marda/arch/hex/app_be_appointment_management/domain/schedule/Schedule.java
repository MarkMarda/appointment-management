package com.marda.arch.hex.app_be_appointment_management.domain.schedule;

import com.marda.arch.hex.app_be_appointment_management.domain.base.Domain;
import com.marda.arch.hex.app_be_appointment_management.domain.exceptions.DomainExceptions;
import com.marda.arch.hex.app_be_appointment_management.domain.person.Doctor;
import com.marda.arch.hex.app_be_appointment_management.domain.person.DoctorId;
import com.marda.arch.hex.app_be_appointment_management.domain.person.DoctorStateEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.util.Objects.isNull;

public class Schedule extends Domain {

    private LocalDateTime initialTime;
    private LocalDateTime finalTime;
    private LocalDate date;
    //private Long doctorId;
    private DoctorId doctorId; // value object
    private ScheduleStateEnum estateSchedule;

    private final Integer SCHEDULE_RANGE = 15;

    public Schedule(LocalDateTime initialTime, LocalDateTime finalTime, Doctor doctor) throws DomainExceptions {
        this.validateSchedule(initialTime, finalTime);
        this.initialTime = initialTime;
        this.finalTime = finalTime;
        this.validateDoctor(doctor);
        //this.doctorId = doctor.getId();
        this.doctorId = new DoctorId(doctor.getId());
        this.estateSchedule = ScheduleStateEnum.AVAILABLE;
    }

    public Schedule(LocalDateTime initialTime, LocalDateTime finalTime, Doctor doctor, ScheduleStateEnum estateSchedule) throws DomainExceptions {
        this(initialTime, finalTime, doctor); // to protect validations
        this.estateSchedule = estateSchedule;
    }

    public Boolean isAvailable() {
        return this.estateSchedule == ScheduleStateEnum.AVAILABLE;
    }

    public void locked() throws ScheduleException {
        if (this.estateSchedule == ScheduleStateEnum.LOCKED) {
            throw new ScheduleException("Schedule is locked");
        }
        if (this.estateSchedule == ScheduleStateEnum.RESERVED) {
            throw new ScheduleException("Schedule is reserved, can not be locked");
        }

        this.estateSchedule = ScheduleStateEnum.LOCKED;
    }

    public void reservate() throws ScheduleException {
        if (this.estateSchedule == ScheduleStateEnum.LOCKED) {
            throw new ScheduleException("Schedule is locked and can not reserved");
        }
        if (this.estateSchedule == ScheduleStateEnum.RESERVED) {
            throw new ScheduleException("Schedule is reserved");
        }

        this.estateSchedule = ScheduleStateEnum.RESERVED;
    }

    public void freeSchedule() throws ScheduleException {
        if (this.estateSchedule == ScheduleStateEnum.LOCKED) {
            throw new ScheduleException("Schedule is locked and can not be available");
        }
        if (this.estateSchedule == ScheduleStateEnum.RESERVED) {
            this.estateSchedule = ScheduleStateEnum.AVAILABLE;
        }

        throw new ScheduleException("Schedule is free");
    }

    private boolean validateSchedule(LocalDateTime initialTime, LocalDateTime finalTime) throws ScheduleException {
        LocalDateTime initialPlus = initialTime.plusMinutes(SCHEDULE_RANGE);
        if (finalTime.isBefore(initialPlus) || finalTime.equals(initialPlus)) {
            throw new ScheduleException("Initial time must be greater than the final time");
        }

        return true;
    }

    private boolean validateDoctor(Doctor doctor) throws ScheduleException {
        if (isNull(doctor) || isNull(doctor.getId())) {
            throw new ScheduleException("Doctor is required");
        }

        if (doctor.getDoctorState() == DoctorStateEnum.LICENSED) {
            throw new ScheduleException("Doctor required in not licensed now");
        }

        return true;
    }

    public LocalDateTime getInitialTime() {
        return initialTime;
    }

    public LocalDateTime getFinalTime() {
        return finalTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public DoctorId getDoctorId() {
        return doctorId;
    }

    public ScheduleStateEnum getEstateSchedule() {
        return estateSchedule;
    }

    @Override
    public boolean valid() throws DomainExceptions {
        return false;
    }
}
