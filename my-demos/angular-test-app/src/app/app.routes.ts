import { Routes } from '@angular/router';
import { UserNavComponent } from './user/nav/nav.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { HomeComponent } from './user/home/home.component';
import { TestComponent } from './test/test.component';
import { HttpTestsComponent } from './user/http-tests/http-tests.component';

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
      },
      {
        path: 'http',
        component: HttpTestsComponent
      }
    ]
  },
  {
    path: '**',
    pathMatch: 'full',
    redirectTo: '/login'
  }
];
