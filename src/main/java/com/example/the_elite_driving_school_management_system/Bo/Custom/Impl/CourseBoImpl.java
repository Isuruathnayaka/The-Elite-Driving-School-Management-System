package com.example.the_elite_driving_school_management_system.Bo.Custom.Impl;

import com.example.the_elite_driving_school_management_system.Bo.Custom.CourseBo;
import com.example.the_elite_driving_school_management_system.Bo.MapUtil;
import com.example.the_elite_driving_school_management_system.DAO.Custom.CourseDAO;
import com.example.the_elite_driving_school_management_system.DTO.CourseDTO;

public class CourseBoImpl implements CourseBo {
    private final CourseDAO courseDAO;

    public CourseBoImpl(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public boolean save(CourseDTO dto) {
        return courseDAO.save(MapUtil.toEntity(dto));
    }

    @Override
    public boolean update(CourseDTO dto) {
        return false;
    }

    @Override
    public String generateNewCourseId() {
        return courseDAO.generateNewId();
    }
}
