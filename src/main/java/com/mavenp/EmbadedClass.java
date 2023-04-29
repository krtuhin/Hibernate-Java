
package com.mavenp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbadedClass {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Student std = new Student();
        std.setS_id(653);
        std.setName("Shubha");
        std.setDepartment("Electrical");
        
        Certificate certificate = new Certificate();
        certificate.setCourse("Web Dev");
        certificate.setDuration("2 months");
        
        std.setCerti(certificate);
        
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        session.save(std);
        
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}