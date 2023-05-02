package com.cache;

import com.mavenp.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevel {

    public static void main(String[] args) {
        SessionFactory f = new Configuration().configure().buildSessionFactory();

        //first session
        Session s = f.openSession();

        Student st = s.get(Student.class, 85);
        System.out.println(st);

        s.close();

        //second session
        Session s2 = f.openSession();

        Student st2 = s2.get(Student.class, 85);
        System.out.println(st2);

        s2.close();

        f.close();
    }
}
