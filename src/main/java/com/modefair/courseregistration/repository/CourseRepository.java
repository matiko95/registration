package com.modefair.courseregistration.repository;

import com.modefair.courseregistration.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAllByDepartment_DepartmentIdIn(List<Long> id);

}
