package com.example.the_elite_driving_school_management_system.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    @Column(name = "InstructorId", nullable = false, unique = true)

    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "contact", nullable = false)
    private String contact;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "registrationDate", nullable = false)
    private LocalDate registrationDate;

    @Column(name = "courseType", nullable = false)
    private String courseType;
    @Column(name = "courseId", nullable = false, unique = true)
    private String courseId;

    public Instructor() {}




    public String getCourse() {
        return courseType;
    }

    public LocalDate getDate() {
        return registrationDate;
    }

    public String getInstructorID() {
        return id;
    }
}
