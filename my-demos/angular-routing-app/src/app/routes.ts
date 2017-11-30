import { Routes } from '@angular/router';

import { PipeComponent } from './components/pipe-demo/pipe-demo.component';
import {HomeComponent} from './components/home/home.component';
import { Child1Component } from './components/child1/child1.component';
import { Child2Component } from './components/child2/child2.component';

export const appRoutes: Routes = [
  {
    path: 'pipe',
    component: PipeComponent
  },
  {
    path: 'home',
    component: HomeComponent,
    children: [
      {
        path: 'one',
        component: Child1Component
      },
      {
        path: 'two',
        component: Child2Component
      }

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

