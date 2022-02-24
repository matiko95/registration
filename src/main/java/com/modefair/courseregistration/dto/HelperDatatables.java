package com.modefair.courseregistration.dto;

import lombok.Data;

import java.util.List;

@Data
public class HelperDatatables<T> {

    private List<T> data;

}
