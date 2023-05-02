package com.sqlquery;

import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQLExample {

    public static void main(String[] args) {
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();

        //SQL query
        String q = "select * from student";

        NativeQuery nq = s.createSQLQuery(q);

        List<Object[]> list = nq.getResultList();

        for (Object[] st : list) {
            System.out.println(Arrays.toString(st));
        }

        //print only 4 number column's value
        for (Object[] student : list) {
            System.out.println(student[4]);
        }

        s.close();
        f.close();
    }
}
