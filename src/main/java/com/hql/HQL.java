package com.hql;

import com.mavenp.Student;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQL {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session s = factory.openSession();
        //HQL
        //syntax
        //String query = "from Student where department='IT'"; //the name Student is Class name not Database table name
        String query = "from Student s where s.department=:x and s.s_id=:n"; //the name Student is Class name not Database table name

        Query q = s.createQuery(query); //getting query object

        //dynamic query
        q.setParameter("x", "Mechanical");
        q.setParameter("n", 9);
        // Single result --> Unique syntax: q.uniqueResult();
        //Multiple result --> List
        List<Student> list = q.getResultList();

        for (Student student : list) {
            System.out.println(student.getName());
        }

        s.close();
        factory.close();
    }
}
