package com.modefair.courseregistration.dto;

import com.modefair.courseregistration.model.Schedule;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class LecturerDto {

    private String lecturerName;

    private Set<String> courseName;

}
