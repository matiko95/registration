package com.modefair.courseregistration.service;

import com.modefair.courseregistration.model.Schedule;
import com.modefair.courseregistration.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    private ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> getAllSchedule(){
        return scheduleRepository.findAll();
    }

    public Schedule getScheduleById(Long id){

        Optional<Schedule> t = scheduleRepository.findById(id);

        Schedule a = new Schedule();
        if(!t.isEmpty()){
            a = t.get();
        }

        return a;
    }
}
