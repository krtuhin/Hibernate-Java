package com.hql;

import com.mavenp.Student;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

        System.out.println("-----------------------------------------------------");

        Transaction tx = s.beginTransaction();

        //delete query
        Query q2 = s.createQuery("delete from Student as s where s.department=:d");

        q2.setParameter("d", "IT");

        int r = q2.executeUpdate();

        System.out.println("Deleted: " + r);

        System.out.println("----------------------..............------------------");

        //update query
        Query q3 = s.createQuery("update Student set department=:c where s_id=:i");

        q3.setParameter("c", "CSE");

        q3.setParameter("i", 2);

        int n = q3.executeUpdate();

        System.out.println(n + " objects updated..");

        tx.commit();
        s.close();
        factory.close();
    }
}
