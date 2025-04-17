import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { RouterModule, Router } from '@angular/router';


import { EmployeeService } from '../services/employee.service';

@Component({
  standalone: true,
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.scss'],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatSnackBarModule
  ]
})
export class EmployeeFormComponent {
  employeeForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private employeeService: EmployeeService,
    private router: Router,
    private snackBar: MatSnackBar
  ) {
    this.employeeForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      position: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.employeeForm.valid) {
      this.employeeService.create(this.employeeForm.value).subscribe({
        next: () => {
          this.snackBar.open('Empleado creado correctamente 🎉', 'Cerrar', {
            duration: 3000
          });
          this.router.navigate(['/employees']);
        },
        error: (err: any) => {
          console.error('Error al guardar empleado:', err);
          this.snackBar.open('Error al crear empleado ❌', 'Cerrar', {
            duration: 3000
          });
        }
      });
    }
  }
}
