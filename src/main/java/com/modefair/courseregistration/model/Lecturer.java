package com.modefair.courseregistration.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "lecturer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecturer_id")
    private Long lecturerId;

    //@Column(length = 9) - sample data contain longer name. change to 90
    @Column(length = 90)
    @NotNull
    private String name;

    @NotNull
    private double salary;

    @ManyToOne
    private Department department;
}
