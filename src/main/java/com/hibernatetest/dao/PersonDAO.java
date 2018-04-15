package com.hibernatetest.dao;

import com.hibernatetest.HibernateUtils;
import com.hibernatetest.entity.onetoone.Person;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO extends AbstractDAO {
    public void createPerson(Person person) {
        Session session = openTransactSession();
        session.save(person);
        closeTransactSession(session);
    }

    public Person getPersonById(long id) {
        Person result = null;
        Session session = openSession();
        result = session.get(Person.class, id);
        session.close();
        return result;
    }

    public void deletePerson(Person person) {
        Session session = openTransactSession();
        session.delete(person);
        closeTransactSession(session);
    }

    public void updatePerson(Person person) {
        Session session = openTransactSession();
        session.saveOrUpdate(person);
        closeTransactSession(session);
    }

    public List<Person> listAll() {
        List<Person> result = new ArrayList<>();
        Session session = openSession();
        result = session.createQuery("from Person", Person.class).list();
        session.close();
        return result;
    }

    public static void main(String[] args) {
        PersonDAO dao = new PersonDAO();

        List<Person> persons = dao.listAll();
        for(Person p: persons) {
            System.out.println(p);
        }

        HibernateUtils.getInstance().close();

    }
}
