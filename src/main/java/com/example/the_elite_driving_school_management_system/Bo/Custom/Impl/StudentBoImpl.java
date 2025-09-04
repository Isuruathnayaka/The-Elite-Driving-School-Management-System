package com.example.the_elite_driving_school_management_system.Bo.Custom.Impl;

import com.example.the_elite_driving_school_management_system.Bo.Custom.StudentBo;
import com.example.the_elite_driving_school_management_system.Bo.MapUtil;
import com.example.the_elite_driving_school_management_system.DAO.Custom.StudentDAO;
import com.example.the_elite_driving_school_management_system.DTO.StudentDTO;
import com.example.the_elite_driving_school_management_system.Entity.Student;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
    public boolean update(StudentDTO dto) {
        return studentDAO.update(MapUtil.toEntity(dto));
    }

    @Override
    public String generateNewStudentId() {
        return studentDAO.generateNewId();
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() {
        ArrayList<Student> students = studentDAO.getAll();
        return students
                .stream()
                .map(MapUtil::toDTO)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public boolean delete(String studentId) {
        return  studentDAO.delete(studentId);
    }

}
