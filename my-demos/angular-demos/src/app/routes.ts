import { Routes } from '@angular/router';

import {InterpolationComponent} from './components/interpolation/interpolation.component';
import {EventBindingComponent} from './components/event-binding/event-binding.component';
import {PropertyBindingComponent} from './components/property-binding/property-binding.component';
import {PipesComponent} from './components/pipes/pipes.component';
import {StructuralDirectiveComponent} from './components/structural-directive/structural-directive.component';
import {TwoWayBindingComponent} from './components/two-way-binding/two-way-binding.component';
import {ParentComponent} from './components/parent/parent.component';
import {Child1Component} from './components/child1/child1.component';
import {Child2Component} from './components/child2/child2.component';
import {HttpCachedComponent} from './components/http-cached/http-cached.component';


export const appRoutes: Routes = [
  {
    path: 'event-bind',
    component: EventBindingComponent
  },
  {
    path: 'http-cached',
    component: HttpCachedComponent
  },
  {
    path: 'interpolation',
    component: InterpolationComponent
  },
  {
    path: 'property-bind',
    component: PropertyBindingComponent
  },
  {
    path: 'pipes',
    component: PipesComponent
  },
  {
    path: 'parent',
    component: ParentComponent,
    children: [
      {
        path: 'child1',
        component: Child1Component
      },
      {
        path: 'child2',
        component: Child2Component
      }
    ]
  },
  {
    path: 'structural-directives',
    component: StructuralDirectiveComponent
  },
  {
    path: 'two-way-binding',
    component: TwoWayBindingComponent
  },
  { path: '',
    redirectTo: '/interpolation',
    pathMatch: 'full'
  },
  { path: '**', component: InterpolationComponent }
];
