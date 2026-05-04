package com.darlellison.airport;

import jakarta.persistence.*;

@Entity
@Table(name = "Managers")
public class Manager {
    @Id
    @GeneratedValue
    private int id;

    public Manager(String name) {
        this.name = name;
    }

    public Manager() {}

    private String name;

    @OneToOne
    @JoinTable(name = "manager_to_department", joinColumns = {
            @JoinColumn(name = "manager_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "department_id", referencedColumnName = "id")
    })
    private Department department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
