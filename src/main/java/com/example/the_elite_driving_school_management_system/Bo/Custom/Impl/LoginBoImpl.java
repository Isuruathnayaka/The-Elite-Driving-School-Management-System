package com.example.the_elite_driving_school_management_system.Bo.Custom.Impl;

import com.example.the_elite_driving_school_management_system.Bo.Custom.LoginBo;
import com.example.the_elite_driving_school_management_system.Bo.MapUtil;
import com.example.the_elite_driving_school_management_system.DAO.Custom.LoginDAO;
import com.example.the_elite_driving_school_management_system.DTO.LoginDTO;

public class LoginBoImpl implements LoginBo {

    private final LoginDAO loginDAO; // mark as final

    // Constructor injection keeps loose coupling
    public LoginBoImpl(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    @Override
    public boolean saveLogin(LoginDTO dto) {
        // Convert DTO → Entity
        return loginDAO.save(MapUtil.toEntity(dto));
    }
}
