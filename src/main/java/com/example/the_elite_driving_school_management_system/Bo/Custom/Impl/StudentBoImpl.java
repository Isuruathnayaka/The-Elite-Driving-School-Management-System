package com.example.the_elite_driving_school_management_system.Bo.Custom.Impl;

import com.example.the_elite_driving_school_management_system.Bo.Custom.StudentBo;
import com.example.the_elite_driving_school_management_system.Bo.MapUtil;
import com.example.the_elite_driving_school_management_system.DAO.Custom.StudentDAO;
import com.example.the_elite_driving_school_management_system.DTO.StudentDTO;
import com.example.the_elite_driving_school_management_system.Entity.Student;
import com.example.the_elite_driving_school_management_system.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentBoImpl implements StudentBo {
    private final StudentDAO studentDAO;

    public StudentBoImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public boolean save(StudentDTO student) {
       return studentDAO.save(MapUtil.toEntity(student));
    }

    @Override
    public String generateNewStudentId() {
        return studentDAO.generateNewId();
    }

}
