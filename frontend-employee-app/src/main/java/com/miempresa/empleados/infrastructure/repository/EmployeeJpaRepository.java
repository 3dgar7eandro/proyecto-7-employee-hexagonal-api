package com.miempresa.empleados.infrastructure.repository;

import com.miempresa.empleados.infrastructure.repository.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeJpaRepository extends JpaRepository<EmployeeEntity, UUID> {
}
