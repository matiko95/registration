package com.modefair.courseregistration.controller;

import com.modefair.courseregistration.dto.HelperDatatables;
import com.modefair.courseregistration.service.CourseService;
import com.modefair.courseregistration.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {

    private CourseService courseService;

    private ScheduleService scheduleService;

    private HelperDatatables data = new HelperDatatables();

    @Autowired
    public CourseController(CourseService courseService, ScheduleService scheduleService) {
        this.courseService = courseService;
        this.scheduleService = scheduleService;
    }

    @GetMapping("/course/getallcourse")
    public ResponseEntity<?> getAllCourse(){


        data.setData(courseService.getAllCourse());
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/course/getcourseschedule")
    public ResponseEntity<?> getCourseSchedule(){

        data.setData(scheduleService.getAllSchedule());
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

}
