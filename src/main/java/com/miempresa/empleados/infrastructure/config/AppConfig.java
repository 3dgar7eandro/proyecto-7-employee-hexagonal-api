package com.miempresa.empleados.infrastructure.config;

import com.miempresa.empleados.application.port.in.*;
import com.miempresa.empleados.application.port.out.EmployeeRepositoryPort;
import com.miempresa.empleados.application.service.EmployeeService;
import com.miempresa.empleados.infrastructure.repository.EmployeeJpaRepository;
import com.miempresa.empleados.infrastructure.repository.EmployeePersistenceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public EmployeeRepositoryPort employeeRepositoryPort(EmployeeJpaRepository repository) {
        return new EmployeePersistenceAdapter(repository);
    }

    @Bean
    public CreateEmployeeUseCase createEmployeeUseCase(EmployeeRepositoryPort port) {
        return new EmployeeService(port);
    }

    @Bean
    public GetAllEmployeesUseCase getAllEmployeesUseCase(EmployeeRepositoryPort port) {
        return new EmployeeService(port);
    }

    @Bean
    public GetEmployeeByIdUseCase getEmployeeByIdUseCase(EmployeeRepositoryPort port) {
        return new EmployeeService(port);
    }

    @Bean
    public DeleteEmployeeUseCase deleteEmployeeUseCase(EmployeeRepositoryPort port) {
        return new EmployeeService(port);
    }
}
