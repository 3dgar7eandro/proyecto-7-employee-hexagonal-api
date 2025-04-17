package com.miempresa.empleados.application.port.in;

import com.miempresa.empleados.domain.model.Employee;

import java.util.UUID;

public interface GetEmployeeByIdUseCase {
    Employee getEmployeeById(UUID id);
}
