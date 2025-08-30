package com.example.the_elite_driving_school_management_system.Bo.Custom;

import com.example.the_elite_driving_school_management_system.DTO.LoginDTO;

public interface LoginBo {
    boolean saveLogin(LoginDTO dto);
    boolean validateLogin(String loginEmail, String loginPassword);
    boolean validateLoginDetails(String email,String password);
}
