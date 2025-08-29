package com.example.the_elite_driving_school_management_system.Bo;

import com.example.the_elite_driving_school_management_system.DTO.LoginDTO;
import com.example.the_elite_driving_school_management_system.Entity.Login;

public class MapUtil {

    public static Login toEntity(LoginDTO dto) {
        return new Login(
                dto.getUsername(),
                dto.getPassword(),
                dto.getEmail()
        );
    }
}
