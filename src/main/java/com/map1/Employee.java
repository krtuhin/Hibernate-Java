package com.map1;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {

    @Id
    @Column(name = "employee_id")
    private int employeeId;

    private String name;

    @ManyToMany
    @JoinTable(
            joinColumns = {
                @JoinColumn(name = "e_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "p_id")
            }
    )
    private List<Project> projects;

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
