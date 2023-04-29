package com.mavenp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {

    public static void main(String[] args) {

        //get or load method
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        //get method
        //get student:132
        Student student = (Student) session.get(Student.class, 132);
        System.out.println(student);

        //load method
        Address address = (Address) session.load(Address.class, 5);
        System.out.println(address.getCity());

        session.close();
        sessionFactory.close();
    }
}
