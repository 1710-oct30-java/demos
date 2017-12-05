import { Routes } from '@angular/router';
import { UserNavComponent } from './user/nav/nav.component';
import { Router} from '@angular/router';
import { LoginComponent } from './login/login.component';

export const appRoutes: Routes = [
  {
    path: 'login', component: LoginComponent
  },
  {
    path: '',
    component: UserNavComponent
  }
];
