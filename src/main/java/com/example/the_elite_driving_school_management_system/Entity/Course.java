package com.example.the_elite_driving_school_management_system.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.xml.namespace.QName;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "courseId", nullable = false, unique = true)
    private String id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "duration", nullable = false)
    private String duration;
    @Column(name = "fee", nullable = false)
    private Double fee;
    @Column (name = "description", nullable = false)
    private String description;

    public Course(String id, String name, String duration, Double fee, String description) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.fee = fee;
        this.description = description;
    }

    public Course() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
