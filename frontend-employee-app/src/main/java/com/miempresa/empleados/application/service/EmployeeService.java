package com.miempresa.empleados.application.service;

import com.miempresa.empleados.application.port.in.*;
import com.miempresa.empleados.application.port.out.EmployeeRepositoryPort;
import com.miempresa.empleados.domain.model.Employee;

import java.util.List;
import java.util.UUID;

public class EmployeeService implements
        CreateEmployeeUseCase,
        GetAllEmployeesUseCase,
        GetEmployeeByIdUseCase,
        DeleteEmployeeUseCase {

    private final EmployeeRepositoryPort employeeRepositoryPort;

    public EmployeeService(EmployeeRepositoryPort employeeRepositoryPort) {
        this.employeeRepositoryPort = employeeRepositoryPort;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepositoryPort.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepositoryPort.findAll();
    }

    @Override
    public Employee getEmployeeById(UUID id) {
        return employeeRepositoryPort.findById(id);
    }

    @Override
    public void deleteEmployeeById(UUID id) {
        employeeRepositoryPort.deleteById(id);
    }
}
