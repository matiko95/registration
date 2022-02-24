package com.modefair.courseregistration.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "schedule")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long scheduleId;

    @ManyToOne
    private Lecturer lecturer;

    @ManyToOne
    private Course course;

    @NotNull
    private int semester;

    @NotNull
    private int year;

    @ManyToMany
    @JoinTable(name="student_schedule",
            joinColumns=@JoinColumn(name="student_id"),
            inverseJoinColumns=@JoinColumn(name="schedule_id"))
    private Set<Student> students = new HashSet<>();

}
