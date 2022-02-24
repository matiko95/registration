package com.modefair.courseregistration.controller;

import com.modefair.courseregistration.dto.HelperDatatables;
import com.modefair.courseregistration.dto.LecturerDto;
import com.modefair.courseregistration.service.LecturerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LecturerController {

    public LecturerServices lecturerServices;

    @Autowired
    public LecturerController(LecturerServices lecturerServices) {
        this.lecturerServices = lecturerServices;
    }

    @GetMapping("/lecturer/getcourseoutside")
    public ResponseEntity<?> getLecturerWithCourseOutsideDepartment(){

        //append 'data' to comply with datatables
        HelperDatatables a = new HelperDatatables();
        a.setData(lecturerServices.getAllLecturerWithCourseOutsideDepartment());
        //return new ResponseEntity<HelperDatatables>(lecturerServices.getAllLecturerWithCourseOutsideDepartment(), HttpStatus.OK);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }


}
