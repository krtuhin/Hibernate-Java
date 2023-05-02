package com.pagination;

import com.mavenp.Student;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLPagination {

    public static void main(String[] args) {

        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();

        Query q = s.createQuery("from Student");

        //implementing pagination using hibernate
        q.setFirstResult(13); //start from where
        q.setMaxResults(8); //number of data 

        List<Student> list = q.getResultList();

        System.out.println("---------------------------------------------------------");

        for (Student st : list) {
            System.out.println(st.getName());
        }

        s.close();
        f.close();
    }
}
