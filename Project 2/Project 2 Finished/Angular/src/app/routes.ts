import { Routes } from '@angular/router';
import { RegComponent } from './components/-reg/-reg.component';
import { LoginComponent } from './components/-login/-login.component';
import { MainComponent } from './components/main/main.component';
import { AuthGuard } from './service/auth.guard';
import { MainLayoutComponent } from './layouts/main-layout.component';
import { LoginLayoutComponent } from './layouts/login-layout.component';
import { ProfileComponent } from './components/profile/profile.component';
import { ChangepassComponent } from './changepass/changepass.component';
import { ChangeinfoComponent } from './changeinfo/changeinfo.component';
import { IreviewedComponent } from './ireviewed/ireviewed.component';

import { RestaurantsComponent } from './restaurants/restaurants.component';
import { SelectedRestaurantComponent } from './selected-restaurant/selected-restaurant.component';
import { RestResolve } from './service/rest.resolve';
import { UserResolve } from './service/user.resolve';
import { SomeProfileComponent } from './some-profile/some-profile.component';
import { MapResolve } from './service/map.resolve';


export const appRoutes: Routes = [

  // routes go here
  {
    path: '',
    component: MainLayoutComponent,
    canActivate: [AuthGuard],
    children: [
      {
        path: '',
        component: MainComponent,
        // children: [
        //   {
        //     path: '',
        //     component: ChooseComponent
        //   }

        // ]
      }
    ]
  },
  {
    path: '',
    component: LoginLayoutComponent,
    children: [
      {
        path: 'login',
        component: LoginComponent
      }
    ]
  },
  {
    path: 'register', component: RegComponent
  },
  {
    path: '', 
    component: MainLayoutComponent,
    // resolve: {
    //   markers: MapResolve
    // },
    children: [
      {
        path: 'profile',
        component: ProfileComponent,
        children: [
          {
            path: 'pass',
            component: ChangepassComponent
          },
          {
            path: 'details',
            component: ChangeinfoComponent
          },
          {
            path: 'ireviewed',
            component: IreviewedComponent,
            resolve: {
              reviews: UserResolve
            }
          },
          {
            path: ':username/:userId',
            component: SomeProfileComponent,
            resolve: {
              reviews: UserResolve
            }
          }
        ]
      },
      {
        path: 'restaurants',
        component: RestaurantsComponent
      },
      {
        path: 'add/:id',
        component: SelectedRestaurantComponent,
        resolve: {
          restaurant: RestResolve
        }
      }
      
    ]
  },

];
