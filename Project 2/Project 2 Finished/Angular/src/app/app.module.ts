import { BrowserModule } from '@angular/platform-browser';
import { NgModule, enableProdMode } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import {AppComponent} from './app.component';
import {NavComponent} from './nav/nav.component';

import { appRoutes } from './routes';

import { AppRoutingModule } from './app-routing.module';
import { RegComponent } from './components/-reg/-reg.component';
import { AuthService } from './service/auth.service';
import { LoginComponent } from './components/-login/-login.component';
import { MainComponent } from './components/main/main.component';
import { AuthGuard } from './service/auth.guard';
import { MainLayoutComponent } from './layouts/main-layout.component';
import { LoginLayoutComponent } from './layouts/login-layout.component';
import { AlertComponent } from './alerts/alert.component';
import { AlertService } from './service/alert.service';

import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';


import { AgmCoreModule } from '@agm/core';
import { GeocodingApiService } from './service/geoapi.service';
import { ProfileComponent } from './components/profile/profile.component';
import { ChangepassComponent } from './changepass/changepass.component';
import { ControlPanelService } from './service/control-panel.service';
import { ChangeinfoComponent } from './changeinfo/changeinfo.component';
import {InlineEditorModule} from '@qontu/ngx-inline-editor';
import { IreviewedComponent } from './ireviewed/ireviewed.component';

import { RestService } from './service/rest-service.service';
import { RestaurantsComponent } from './restaurants/restaurants.component';
import { SelectedRestaurantComponent } from './selected-restaurant/selected-restaurant.component';
import { RestResolve } from './service/rest.resolve';
import { UserResolve } from './service/user.resolve';
import { SomeProfileComponent } from './some-profile/some-profile.component';
import { MapService } from './service/map.service';
import { MapResolve } from './service/map.resolve';
import { NguiMapModule } from '@ngui/map';


@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    RouterModule.forRoot(appRoutes, { useHash: true }),
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyAncGW5Fke707z9MxCTKZKT9f0w6QFhAcs'
    }),
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    InlineEditorModule,
    NguiMapModule.forRoot({apiUrl: 'https://maps.google.com/maps/api/js?key=AIzaSyAncGW5Fke707z9MxCTKZKT9f0w6QFhAcs'})
    
  ],
  declarations: [
    AppComponent,
    NavComponent,
    LoginComponent,
    RegComponent,
    MainComponent,
    MainLayoutComponent,
    LoginLayoutComponent,
    AlertComponent,
    ProfileComponent,
    ChangepassComponent,
    ChangeinfoComponent,
    IreviewedComponent,
    RestaurantsComponent,
    SelectedRestaurantComponent,
    SomeProfileComponent

   ],
  providers: [
    AuthService,
    AuthGuard,
    AlertService,
    ControlPanelService,
    GeocodingApiService,
    RestService,
    MapService,
    RestResolve,
    UserResolve,
    MapResolve
    
   ],
  bootstrap: [AppComponent ]
})
export class AppModule { }
platformBrowserDynamic().bootstrapModule(AppModule);