package com.example.the_elite_driving_school_management_system.DAO.Custom.impl;

import com.example.the_elite_driving_school_management_system.DAO.Custom.LoginDAO;
import com.example.the_elite_driving_school_management_system.Entity.Login;
import com.example.the_elite_driving_school_management_system.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoginDAOimpl implements LoginDAO {
    @Override
    public boolean save(Login login) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            session.save(login);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Login dto) {
        return false;
    }

    @Override
    public Login findByEmail(String email) {
       try(Session session = HibernateUtil.getSessionFactory().openSession()){
           return session.createQuery("from Login where email = :email", Login.class).setParameter("email", email).uniqueResult();

        }
    }


}


