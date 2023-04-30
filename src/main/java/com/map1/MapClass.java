package com.map1;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapClass {

    public static void main(String[] args) {

        //configuration
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //employee object
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        Employee emp3 = new Employee();

        //project object
        Project p = new Project();
        Project p1 = new Project();

        //employee and project list
        List<Employee> list1 = new ArrayList<>();
        List<Project> list2 = new ArrayList<>();

        list1.add(emp1);
        list1.add(emp2);
        list1.add(emp3);

        list2.add(p);
        list2.add(p1);

        //creating employee
        emp1.setEmployeeId(33);
        emp1.setName("Shyam");
        emp1.setProjects(list2);

        emp2.setEmployeeId(63);
        emp2.setName("Sunil");

        emp3.setEmployeeId(52);
        emp3.setName("Rathin");
        emp3.setProjects(list2);

        //creating projects
        p.setProjectId(073);
        p.setProjectName("Chat Application");
        p.setEmployees(list1);

        p1.setProjectId(005);
        p1.setProjectName("Student Management System");
        p1.setEmployees(list1);

        //session
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(emp1);
        session.save(emp2);
        session.save(emp3);
        session.save(p1);
        session.save(p);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
