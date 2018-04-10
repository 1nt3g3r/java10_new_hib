package com.hibernatetest.dao;

import com.hibernatetest.HibernateUtils;
import org.hibernate.Session;

public class AbstractDAO {
    public Session openSession() {
        return HibernateUtils.getInstance().createSession();
    }
}
