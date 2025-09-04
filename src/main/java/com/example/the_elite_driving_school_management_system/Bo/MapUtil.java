package com.example.the_elite_driving_school_management_system.Bo;

import com.example.the_elite_driving_school_management_system.DTO.LoginDTO;
import com.example.the_elite_driving_school_management_system.DTO.StudentDTO;
import com.example.the_elite_driving_school_management_system.Entity.Login;
import com.example.the_elite_driving_school_management_system.Entity.Student;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class MapUtil {

    public static Login toEntity(LoginDTO dto) {
        return new Login(
                dto.getUsername(),
                dto.getPassword(),
                dto.getEmail()
        );
    }

    public static Student toEntity(StudentDTO student) {
        Date date = null;
        LocalDate localDate = student.getDate();
        if (localDate != null) {
            date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
        return new Student(
                student.getStudentID(),
                student.getName(),
                student.getAge(),
                student.getAddress(),
                student.getContact(),
                student.getEmail(),
                student.getDate(),   // converted Date here
                student.getCourse(),
                student.getCourseId()
        );
    }
}
