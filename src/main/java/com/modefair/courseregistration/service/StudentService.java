package com.modefair.courseregistration.service;

import com.modefair.courseregistration.model.Student;
import com.modefair.courseregistration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void saveRecord(Student student){
        studentRepository.save(student);
    }

    public List<Student> getAllRegisteredStudent(){
        return studentRepository.findAll();
    }
}
