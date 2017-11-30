import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { UIRouterModule } from '@uirouter/angular';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import {AppComponent} from './app.component';
import {NavComponent} from './nav/nav.component';
import {FirstComponent} from './components/first/first.component';
import {BeanComponent} from './components/bean/bean.component'
import {LoginComponent} from './components/login/login.component'

import {LoginService} from './components/login/login.service'

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { appRoutes } from './routes';
import { ReimbursementComponent } from './components/my-reimbursements/my-reimbursements.component';
import { TypeIdPipe } from './typeId-pipe';
import { EmployeePipe } from './employeePipe';
import { StatusPipe } from './statusPipe';
import { RequestsComponent } from './components/my-requests/my-requests.component';

@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    NgbModule.forRoot(),
    RouterModule.forRoot(appRoutes),
    FormsModule,
    BrowserModule,
    BrowserAnimationsModule,
  ],
  declarations: [
    AppComponent,
    NavComponent,
    FirstComponent,
    BeanComponent,
    LoginComponent,
    ReimbursementComponent,
    TypeIdPipe,
    EmployeePipe,
    StatusPipe,
    RequestsComponent,
   ],
  providers: [
    LoginService,
   ],
  bootstrap: [AppComponent]
})
export class AppModule { }
