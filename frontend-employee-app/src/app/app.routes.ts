import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'employees',
    pathMatch: 'full'
  },
  {
    path: 'employees',
    loadComponent: () =>
      import('./pages/employee-list/employee-list.component').then(
        (m) => m.EmployeeListComponent
      )
  },
  {
    path: 'employees/new',
    loadComponent: () =>
      import('./pages/employee-form.component').then(
        (m) => m.EmployeeFormComponent
      )
  }
];




