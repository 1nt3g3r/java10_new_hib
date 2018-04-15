package com.hibernatetest.dao;

import com.hibernatetest.HibernateUtils;
import org.hibernate.Session;

public class AbstractDAO {
    public Session openSession() {
        return HibernateUtils.getInstance().createSession();
    }

    public Session openTransactSession() {
        Session session = openSession();
        session.beginTransaction();
        return session;
    }

    public void closeTransactSession(Session session) {
        session.getTransaction().commit();
        session.close();
    }
}
