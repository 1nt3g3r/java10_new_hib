package com.hibernatetest.dao;

import com.hibernatetest.entity.Person;
import com.hibernatetest.entity.PersonInfo;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonDAO extends AbstractDAO {
    public void createPerson(Person person) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();

        session.save(person);

        transaction.commit();
        session.close();
    }

    public static void main(String[] args) {
        PersonDAO dao = new PersonDAO();

        Person person = new Person();
        person.setFirstName("Толя");

        PersonInfo info = new PersonInfo();
        info.setPassportNumber("ВК124567");

        person.setPersonInfo(info);
        info.setPerson(person);

        dao.createPerson(person);

        System.out.println(person.getPersonInfo().getPersonId());
    }
}
