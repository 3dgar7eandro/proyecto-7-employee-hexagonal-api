package com.miempresa.empleados.application.port.in;

import com.miempresa.empleados.domain.model.Employee;

import java.util.List;

public interface GetAllEmployeesUseCase {
    List<Employee> getAllEmployees();
}
