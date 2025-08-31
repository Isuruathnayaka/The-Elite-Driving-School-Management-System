package com.example.the_elite_driving_school_management_system.DTO;

import java.time.LocalDate;
import java.util.Date;

public class StudentDTO {
    private String studentID;
    private String name;
    private int age;
    private String address;
    private String contact;
    private String email;
    private Date date;
    private String course;

    public StudentDTO(String studentID, String name, int age, String address, String contact, String email, LocalDate date, String course) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.date = date;
        this.course = course;

    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
