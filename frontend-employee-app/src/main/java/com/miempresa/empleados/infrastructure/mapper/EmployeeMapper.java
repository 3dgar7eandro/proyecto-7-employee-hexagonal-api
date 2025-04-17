package com.miempresa.empleados.infrastructure.mapper;

import com.miempresa.empleados.domain.model.Employee;
import com.miempresa.empleados.shared.dto.EmployeeDTO;
import com.miempresa.empleados.infrastructure.repository.entity.EmployeeEntity;

public class EmployeeMapper {

    public static EmployeeDTO toDTO(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getPosition(),
                employee.getDepartment(),
                employee.getSalary()
        );
    }

    public static Employee toDomain(EmployeeDTO dto) {
        return new Employee(
                dto.getId(),
                dto.getName(),
                dto.getPosition(),
                dto.getDepartment(),
                dto.getSalary()
        );
    }

    public static EmployeeEntity toEntity(Employee employee) {
        return new EmployeeEntity(
                employee.getId(),
                employee.getName(),
                employee.getPosition(),
                employee.getDepartment(),
                employee.getSalary()
        );
    }

    public static Employee toDomain(EmployeeEntity entity) {
        return new Employee(
                entity.getId(),
                entity.getName(),
                entity.getPosition(),
                entity.getDepartment(),
                entity.getSalary()
        );
    }
}

