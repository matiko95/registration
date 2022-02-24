package com.modefair.courseregistration.repository;

import com.modefair.courseregistration.model.Course;
import com.modefair.courseregistration.model.Lecturer;
import com.modefair.courseregistration.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    //List<Schedule> findAllByLecturer_LecturerId(List<Integer> id);
    List<Schedule> findAllByLecturer(Lecturer a);

}
