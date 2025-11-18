package com.marda.arch.hex.app_be_appointment_management.adapter.out.dbs.sql.mysql.mappers;

import com.marda.arch.hex.app_be_appointment_management.adapter.out.dbs.sql.exceptions.ScheduleAdapterDBException;
import com.marda.arch.hex.app_be_appointment_management.adapter.out.dbs.sql.mysql.entities.ScheduleEntity;
import com.marda.arch.hex.app_be_appointment_management.domain.exceptions.DomainExceptions;
import com.marda.arch.hex.app_be_appointment_management.domain.person.Doctor;
import com.marda.arch.hex.app_be_appointment_management.domain.schedule.Schedule;
import com.marda.arch.hex.app_be_appointment_management.domain.schedule.ScheduleStateEnum;
import org.springframework.stereotype.Component;

@Component
public class ScheduleAdapterDBMapperImpl implements ScheduleAdapterDBMapper {
    @Override
    public ScheduleEntity toEntity(Schedule schedule) {
        return ScheduleEntity
                .builder()
                .id(schedule.getId())
                .date(schedule.getDate())
                .initialTime(schedule.getInitialTime())
                .finalTime(schedule.getFinalTime())
                .estateSchedule(schedule.getEstateSchedule().getValue())
                //.estateRegister(schedule.getEstate().getValue())
                .build();
    }

    @Override
    public Schedule toDomain(ScheduleEntity scheduleEntity) throws ScheduleAdapterDBException {
        try {
            Schedule schedule = new Schedule(
                    scheduleEntity.getId(),
                    scheduleEntity.getInitialTime(),
                    scheduleEntity.getFinalTime(),
                    new Doctor(scheduleEntity.getDoctorId()),
                    ScheduleStateEnum.getByValue(scheduleEntity.getEstateSchedule())

            );
        } catch (DomainExceptions e) {
            throw new ScheduleAdapterDBException(e);
        }
        return null;
    }
}
