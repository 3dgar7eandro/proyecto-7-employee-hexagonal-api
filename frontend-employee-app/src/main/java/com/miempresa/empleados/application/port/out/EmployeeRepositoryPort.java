package com.miempresa.empleados.application.port.out;

import com.miempresa.empleados.domain.model.Employee;
import java.util.List;
import java.util.UUID;

public interface EmployeeRepositoryPort {

    Employee save(Employee employee);

    List<Employee> findAll();

    Employee findById(UUID id);

    void deleteById(UUID id);
}
