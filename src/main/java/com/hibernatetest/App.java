package com.hibernatetest;

import com.hibernatetest.cruddao.CrudDaoFactory;
import com.hibernatetest.entity.onetoone.PersonInfo;

public class App {
    public static void main(String[] args) {
        CrudDaoFactory daoFactory = new CrudDaoFactory();

        PersonInfo info = daoFactory.getDao(PersonInfo.class).getById(3L);
        System.out.println(info.getFamilyState());

        HibernateUtils.getInstance().close();
    }
}
