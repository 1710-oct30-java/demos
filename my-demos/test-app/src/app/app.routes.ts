import { Routes } from '@angular/router';
import { UserNavComponent } from './user/nav/nav.component';
<<<<<<< HEAD
import { Router} from '@angular/router';
import { LoginComponent } from './login/login.component';

export const appRoutes: Routes = [
  {
    path: 'login', component: LoginComponent
  },
  {
    path: '',
    component: UserNavComponent
=======
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { HomeComponent } from './user/home/home.component';
import { TestComponent } from './test/test.component';

export const appRoutes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'user',
    component: UserComponent,
    children: [
      {
        path: 'home',
        component: HomeComponent
      },
      {
        path: 'test/:id',
        component: TestComponent
      }
    ]
  },
  {
    path: '**',
    pathMatch: 'full',
    redirectTo: '/login'
>>>>>>> 77cbed5c25e0a490dca6d04d6a3493d8bafff454
  }
];
