package com.example.the_elite_driving_school_management_system.Bo;

import com.example.the_elite_driving_school_management_system.DTO.InstructorDTO;
import com.example.the_elite_driving_school_management_system.DTO.LoginDTO;
import com.example.the_elite_driving_school_management_system.DTO.StudentDTO;
import com.example.the_elite_driving_school_management_system.Entity.Instructor;
import com.example.the_elite_driving_school_management_system.Entity.Login;
import com.example.the_elite_driving_school_management_system.Entity.Student;

public class MapUtil {

    // ==================== Login ====================
    public static Login toEntity(LoginDTO dto) {
        return new Login(
                dto.getUsername(),
                dto.getPassword(),
                dto.getEmail()
        );
    }

    // ==================== Student ====================
    public static Student toEntity(StudentDTO dto) {
        return new Student(
                dto.getStudentID(),
                dto.getName(),
                dto.getAge(),
                dto.getAddress(),
                dto.getContact(),
                dto.getEmail(),
                dto.getDate(),       // LocalDate (works fine in your entity)
                dto.getCourse(),
                dto.getCourseId()
        );
    }

    public static StudentDTO toDTO(Student entity) {
        return new StudentDTO(
                entity.getId(),
                entity.getName(),
                entity.getAge(),
                entity.getAddress(),
                entity.getContact(),
                entity.getEmail(),
                entity.getRegistrationDate(),  // LocalDate
                entity.getCourseType(),
                entity.getCourseId()
        );
    }

    // ==================== Instructor ====================
    public static Instructor toEntity(InstructorDTO dto) {
        return new Instructor(
                dto.getInstructorID(),
                dto.getName(),
                dto.getAge(),
                dto.getAddress(),
                dto.getContact(),
                dto.getEmail(),
                dto.getDate(),        // LocalDate (or Date if your entity uses Date)
                dto.getCourse(),
                dto.getCourseId()
        );
    }

    public static InstructorDTO toDTO(Instructor entity) {
        return new InstructorDTO(
                entity.getId(),
                entity.getName(),
                entity.getAge(),
                entity.getAddress(),
                entity.getContact(),
                entity.getEmail(),
                entity.getRegistrationDate(),  // LocalDate
                entity.getCourse(),
                entity.getCourseId()
        );
    }


}
