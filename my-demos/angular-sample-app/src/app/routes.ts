import { Routes } from '@angular/router';

// components
import { PipeDemoComponent } from './components/pipe-demo/pipe-demo.component';
import { HomeComponent } from './components/home/home.component';
import {HomeChild1Component} from './components/child1/child1.component';
import {HomeChild2Component} from './components/child2/child2.component';


export const appRoutes: Routes = [
  {
    path: 'pipe',
    component: PipeDemoComponent
  },
  {
    path: 'home',
    component: HomeComponent,
    children: [
      {
        path: 'one',
        component: HomeChild1Component
      },
      {
        path: 'two',
        component: HomeChild2Component
      },
      {
        path: '',
        redirectTo: 'one',
        pathMatch: 'full'
      },
    ]
  },
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: '**',
    redirectTo: '/home',
    pathMatch: 'full'
  }
];
