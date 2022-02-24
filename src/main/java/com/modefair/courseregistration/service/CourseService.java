package com.modefair.courseregistration.service;

import com.modefair.courseregistration.model.Course;
import com.modefair.courseregistration.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {


    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

}
