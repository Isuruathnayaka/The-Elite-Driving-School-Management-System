package com.example.the_elite_driving_school_management_system.TM;

import java.time.LocalDate;

public class StudentTM implements Comparable<StudentTM>{
    private String id;
    private String name;
    private int age;
    private String address;
    private String contact;
    private String email;
    private LocalDate date;
    private String course;
    public String getId() {
  return id;
    }

    @Override
    public int compareTo(StudentTM o) {
        return this.id.compareTo(o.id);
    }
}
