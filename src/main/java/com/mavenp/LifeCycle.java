package com.mavenp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LifeCycle {

    public static void main(String[] args) {

        //Hibernate Object States
        //Transient
        //Persistent
        //Detached
        //Removed
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        //student object
        Student student = new Student();

        student.setS_id(0013);
        student.setName("Sanjay");
        student.setDepartment("Electrical");
        student.setCerti(new Certificate("Java development Course", "3.6 months."));
        //student : Transient
        //now Student object is in Transient State

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student);
        //student : Persistent --> session, database

        student.setName("Sunil");//change name in database also because associated

        tx.commit();
        session.close();
        //student : Detached

        student.setName("Rahul");
        System.out.println(student);

        sessionFactory.close();
    }
}
