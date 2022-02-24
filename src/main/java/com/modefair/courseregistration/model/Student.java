package com.modefair.courseregistration.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @NotNull
    @Column(length = 255) //default jpa is 255
    private String name;

    @ManyToMany
    @JoinTable(name="student_schedule",
            joinColumns=@JoinColumn(name="student_id"),
            inverseJoinColumns=@JoinColumn(name="schedule_id"))
    private Set<Schedule> schedule = new HashSet<>();
}
