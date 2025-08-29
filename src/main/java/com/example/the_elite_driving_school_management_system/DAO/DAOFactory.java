package com.example.the_elite_driving_school_management_system.DAO;

import com.example.the_elite_driving_school_management_system.DAO.Custom.impl.LoginDAOimpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory() {}
    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    public enum DAOType {
        LOGIN
    }
    public LoginDAOimpl getDAO(DAOType type) {
        switch (type) {
            case LOGIN:
                return new LoginDAOimpl();
        }
        return null;
    }
}
