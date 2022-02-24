package com.modefair.courseregistration.controller;

import com.modefair.courseregistration.dto.HelperDatatables;
import com.modefair.courseregistration.model.Schedule;
import com.modefair.courseregistration.model.Student;
import com.modefair.courseregistration.service.ScheduleService;
import com.modefair.courseregistration.service.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

@Controller
public class StudentController {

    private StudentService studentService;

    private ScheduleService scheduleService;

    HelperDatatables data = new HelperDatatables();

    @Autowired
    public StudentController(StudentService studentService, ScheduleService scheduleService) {
        this.studentService = studentService;
        this.scheduleService = scheduleService;
    }

    @PostMapping("/schedule/addStudent")
    public String addStudent(@RequestParam("name") String name, @RequestParam("scheduleId") String tempScheduleId){

        Student newStudent = new Student();
        newStudent.setName(name);

        Set<Schedule> schedule = new HashSet<>();

        schedule.add(scheduleService.getScheduleById(Long.parseLong(tempScheduleId)));

        newStudent.setSchedule(schedule);

        studentService.saveRecord(newStudent);

        return "redirect:/scheduleList";
    }

    @GetMapping("/student/getAllStudent")
    public ResponseEntity<?> getAllRegisteredStudent(){

        data.setData(studentService.getAllRegisteredStudent());

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

}
