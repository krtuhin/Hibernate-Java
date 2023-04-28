package com.mavenp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //it is the annotation to represent a class as a table in database
//@Table(name = "student_details") used to change the table name of the entity
public class Student {

    @Id //consider the variable as primary key of the table
    private int s_id;
    private String name;
    private String department;

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

    //for printing the details
    @Override
    public String toString() {
        return "Student{" + "s_id=" + s_id + ", name=" + name + ", department=" + department + '}';
    }
}
