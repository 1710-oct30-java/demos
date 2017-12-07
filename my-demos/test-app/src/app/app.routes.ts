import { Routes } from '@angular/router';
import { UserNavComponent } from './user/nav/nav.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { Component } from '@angular/core/src/metadata/directives';
import { HomeComponent } from './user/home/home.component';
import { TestComponent } from './user/test/test.component';

export const appRoutes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'user',
    component: UserComponent,
    children: [{
      path: 'home',
      component: HomeComponent
    },
    {
      path: 'test/:id',
      component: TestComponent
    }]
  }
];
