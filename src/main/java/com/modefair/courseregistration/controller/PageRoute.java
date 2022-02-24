package com.modefair.courseregistration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

}
