package com.miempresa.empleados.shared.dto;

import java.util.UUID;

public class EmployeeDTO {

    private UUID id;
    private String name;
    private String position;
    private String department;
    private double salary;

    public EmployeeDTO() {}

    public EmployeeDTO(UUID id, String name, String position, String department, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.department = department;
        this.salary = salary;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
