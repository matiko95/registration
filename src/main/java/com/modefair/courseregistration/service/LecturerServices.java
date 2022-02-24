package com.modefair.courseregistration.service;

import com.modefair.courseregistration.dto.LecturerDto;
import com.modefair.courseregistration.model.Course;
import com.modefair.courseregistration.model.Department;
import com.modefair.courseregistration.model.Lecturer;
import com.modefair.courseregistration.model.Schedule;
import com.modefair.courseregistration.repository.CourseRepository;
import com.modefair.courseregistration.repository.LecturerRepository;
import com.modefair.courseregistration.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LecturerServices {

    private ScheduleRepository scheduleRepository;

    private LecturerRepository lecturerRepository;

    private CourseRepository courseRepository;

    @Autowired
    public LecturerServices(ScheduleRepository scheduleRepository, LecturerRepository lecturerRepository, CourseRepository courseRepository) {
        this.scheduleRepository = scheduleRepository;
        this.lecturerRepository = lecturerRepository;
        this.courseRepository = courseRepository;
    }

    public List<LecturerDto> getAllLecturerWithCourseOutsideDepartment(){

        //List<Long> ids = lecturerRepository.findAll().stream().map(Lecturer::getLecturerId).collect(Collectors.toList());
        List<Lecturer> lecturers = lecturerRepository.findAll();

        List<LecturerDto> lecturerDtos = new ArrayList<>();

        //stream object data
        for( Lecturer a : lecturers){

            //filter lecturer data - filter out current department
            List<Long> dpID = scheduleRepository.findAllByLecturer(a).stream()
                    .map(Schedule::getCourse)
                    .map(Course::getDepartment)
                    .filter(department -> department.getDepartmentId() != a.getDepartment().getDepartmentId())
                    .map(Department::getDepartmentId)
                    .collect(Collectors.toList());


            LecturerDto data = new LecturerDto();
            data.setLecturerName(a.getName());
            //get course data outside of lecturer department using department id
            data.setCourseName(courseRepository.findAllByDepartment_DepartmentIdIn(dpID).stream().map(Course::getName).collect(Collectors.toSet()));

            //get all course with lecturer data without redundency
            /*data.setCourseName(scheduleRepository.findAllByLecturer(a).stream()
                    .map(Schedule::getCourse)
                    .map(Course::getName)
                    .collect(Collectors.toSet()));*/

            lecturerDtos.add(data);

        }

        return lecturerDtos;
    }



}
