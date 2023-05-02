package com.mavenp;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity //it is the annotation to represent a class as a table in database
//@Table(name = "student_details") used to change the table name of the entity
@Cacheable //to use cache
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY) //cache use type strategy
public class Student {

    @Id //consider the variable as primary key of the table
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int s_id;
    private String name;
    private String department;
    private Certificate certi;

    public Student(int s_id, String name, String department) {
        this.s_id = s_id;
        this.name = name;
        this.department = department;
    }

    public Student() {
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Certificate getCerti() {
        return certi;
    }

    public void setCerti(Certificate certi) {
        this.certi = certi;
    }

    //for printing the details
    @Override
    public String toString() {
        return "Student{" + "s_id=" + s_id + ", name=" + name + ", department=" + department + '}';
    }
}
