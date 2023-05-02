package com.cache;

import com.mavenp.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevel {

    public static void main(String[] args) {
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();

        //by default enabled
        Student st = s.get(Student.class, 55);
        System.out.println(st);

        System.out.println("--------------------------------------------------");

        /*for this data hibernate will not execute any query, just take data from
        session cache/first level cache*/
        Student st1 = s.get(Student.class, 55);
        System.out.println(st1);

        //print session have this object or not
        System.out.println(s.contains(st1));

        s.close();
        f.close();
    }
}
