package com.mavenp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {
        System.out.println("Project started....");
//        configure("hibernate.cfg.xml") we can also write this when the location and file name is not appropriate 

        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Student st = new Student(110,"Rohit","CSE");
        
        System.out.println(st.toString());
        
        Session session = sessionFactory.openSession();
        
        Transaction transaction =  session.beginTransaction();
        
        session.save(st);
        
        transaction.commit();
        
        //we can also write the commit syntax as below
//        session.getTransaction().commit();
        
        session.close();
    }
}
