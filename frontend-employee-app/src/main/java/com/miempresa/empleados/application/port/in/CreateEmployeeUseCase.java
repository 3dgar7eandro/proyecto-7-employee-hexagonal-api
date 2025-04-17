package com.miempresa.empleados.application.port.in;

import com.miempresa.empleados.domain.model.Employee;

public interface CreateEmployeeUseCase {
    Employee createEmployee(Employee employee);
}
