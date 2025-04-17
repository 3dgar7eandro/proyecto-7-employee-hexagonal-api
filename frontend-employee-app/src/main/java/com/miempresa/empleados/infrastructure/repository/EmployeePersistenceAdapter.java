package com.miempresa.empleados.infrastructure.repository;

import com.miempresa.empleados.application.port.out.EmployeeRepositoryPort;
import com.miempresa.empleados.domain.model.Employee;
import com.miempresa.empleados.infrastructure.mapper.EmployeeMapper;
import com.miempresa.empleados.infrastructure.repository.entity.EmployeeEntity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class EmployeePersistenceAdapter implements EmployeeRepositoryPort {

    private final EmployeeJpaRepository repository;

    public EmployeePersistenceAdapter(EmployeeJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee save(Employee employee) {
        EmployeeEntity entity = EmployeeMapper.toEntity(employee);
        return EmployeeMapper.toDomain(repository.save(entity));
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll().stream()
                .map(EmployeeMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Employee findById(UUID id) {
        return repository.findById(id)
                .map(EmployeeMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
