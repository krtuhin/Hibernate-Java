package com.mavenp;

import java.io.FileInputStream;
import java.util.Date;
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

        Student st = new Student(131, "Raja", "ECE");

        System.out.println(st);

        //creating object of address class
        Address ad = new Address();

        ad.setStreet("Street_2");
        ad.setCity("Delhi");
        ad.setIsOpen(false);
        ad.setAddedDate(new Date());
        ad.setX(0.999);

        //reading image
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/pic.jpg");
            byte[] data = new byte[fis.available()];
            fis.read(data);
            ad.setImage(data);
        } catch (Exception e) {
        }

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(st);

        session.save(ad);

        transaction.commit();

        //we can also write the commit syntax as below
//        session.getTransaction().commit();
        session.close();
        System.out.println("Done...");
    }
}
