package com.miempresa.empleados.application.port.in;

import java.util.UUID;

public interface DeleteEmployeeUseCase {
    void deleteEmployeeById(UUID id);
}
