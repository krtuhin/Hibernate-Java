package com.mavenp;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {
        System.out.println("Project started....");
//        configure("hibernate.cfg.xml") we can also write this when the location and file name is not appropriate 

        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        System.out.println(sessionFactory);
        System.out.println(sessionFactory.isClosed());
    }
}
