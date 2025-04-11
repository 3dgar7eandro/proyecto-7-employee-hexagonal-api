package com.miempresa.empleados.infrastructure.controller;

import com.miempresa.empleados.application.port.in.*;
import com.miempresa.empleados.shared.dto.EmployeeDTO;
import com.miempresa.empleados.domain.model.Employee;
import com.miempresa.empleados.infrastructure.mapper.EmployeeMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final CreateEmployeeUseCase createEmployeeUseCase;
    private final GetAllEmployeesUseCase getAllEmployeesUseCase;
    private final GetEmployeeByIdUseCase getEmployeeByIdUseCase;
    private final DeleteEmployeeUseCase deleteEmployeeUseCase;

    public EmployeeController(
            CreateEmployeeUseCase createEmployeeUseCase,
            GetAllEmployeesUseCase getAllEmployeesUseCase,
            GetEmployeeByIdUseCase getEmployeeByIdUseCase,
            DeleteEmployeeUseCase deleteEmployeeUseCase
    ) {
        this.createEmployeeUseCase = createEmployeeUseCase;
        this.getAllEmployeesUseCase = getAllEmployeesUseCase;
        this.getEmployeeByIdUseCase = getEmployeeByIdUseCase;
        this.deleteEmployeeUseCase = deleteEmployeeUseCase;
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO dto) {
        Employee employee = EmployeeMapper.toDomain(dto);
        Employee saved = createEmployeeUseCase.createEmployee(employee);
        return EmployeeMapper.toDTO(saved);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return getAllEmployeesUseCase.getAllEmployees().stream()
                .map(EmployeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable UUID id) {
        Employee employee = getEmployeeByIdUseCase.getEmployeeById(id);
        return EmployeeMapper.toDTO(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable UUID id) {
        deleteEmployeeUseCase.deleteEmployeeById(id);
    }
}
