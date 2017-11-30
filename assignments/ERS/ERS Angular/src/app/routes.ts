import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { ReimbursementComponent } from './components/my-reimbursements/my-reimbursements.component';
import { RequestsComponent } from './components/my-requests/my-requests.component';

export const appRoutes: Routes = [
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'reimbursements',
    component: ReimbursementComponent,
  },
  {
    path: 'myrequests',
    component: RequestsComponent,
  },
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  {
    path: '**',
    redirectTo: '/login',
    pathMatch: 'full'
  }
];
