package com.example.the_elite_driving_school_management_system.DAO.Custom.impl;

import com.example.the_elite_driving_school_management_system.DAO.Custom.CourseDAO;
import com.example.the_elite_driving_school_management_system.Entity.Course;
import com.example.the_elite_driving_school_management_system.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public boolean save(Course dto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            // Use persist() instead of save() for Hibernate 6.0+
            session.persist(dto);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }

    }

    @Override
    public boolean update(Course dto) {
        return false;
    }

    @Override
    public String generateNewId() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Get the last courseId (ordered descending)
            String lastId = session.createQuery(
                            "SELECT c.id FROM Course c ORDER BY c.id DESC", String.class
                    )
                    .setMaxResults(1)   // only take top 1
                    .uniqueResult();

            if (lastId != null) {
                // Extract digits only
                String numericPart = lastId.replaceAll("\\D", "");
                int newId = Integer.parseInt(numericPart) + 1;

                // Format as C1001, C1002, etc.
                return String.format("C%d", newId);
            } else {
                return "C1001"; // first ID
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "C1001"; // fallback to first ID if query fails
        }

    }
}
