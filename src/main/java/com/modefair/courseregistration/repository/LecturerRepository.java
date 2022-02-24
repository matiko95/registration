package com.modefair.courseregistration.repository;

import com.modefair.courseregistration.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Lecturer, Long> {

    //leave find all to jpa
}
