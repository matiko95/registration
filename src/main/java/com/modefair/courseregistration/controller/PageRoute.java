package com.modefair.courseregistration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageRoute {

    @GetMapping("/index")
    public String homepage(){
        return "index";
    }

    @GetMapping("/lecturerList")
    public String lecturerList(){
        return "lecturerList";
    }

    @GetMapping("/courseList")
    public String courseList(){
        return "course";
    }

    @GetMapping("/studentList")
    public String studentList(){
        return "listStudent";
    }

    @GetMapping("/scheduleList")
    public String scheduleList(){
        return "schedule";
    }

    @GetMapping("/addStudent/{scheduleId}")
    public String addStudentForm(@PathVariable("scheduleId") String scheduleId, Model model){

        model.addAttribute("scheduleId", scheduleId);
        return "addStudent";
    }

}
