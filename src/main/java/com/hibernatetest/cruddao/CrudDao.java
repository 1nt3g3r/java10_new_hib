package com.hibernatetest.cruddao;

import com.hibernatetest.HibernateUtils;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CrudDao<T, K> {
    private Class<T> tClass;

    public CrudDao(Class tClass) {
        this.tClass = tClass;
    }

    public void create(T object) {
        Session session = openTransactSession();
        session.save(object);
        closeTransactSession(session);
    };

    public T getById(K id) {
        T result = null;
        Session session = openSession();
        result = session.get(tClass, (Serializable) id);
        session.close();
        return result;
    }

    public void update(T object) {
        Session session = openTransactSession();
        session.update(object);
        closeTransactSession(session);
    }

    public void delete(T object) {
        Session session = openTransactSession();
        session.delete(object);
        closeTransactSession(session);
    }

    public List<T> listAll() {
        List<T> result = new ArrayList<>();

        String entityName = tClass.getSimpleName();
        String hql = "from " + entityName;

        Session session = openSession();
        result = session.createQuery(hql, tClass).list();
        session.close();

        return result;
    }

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
