import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { UIRouterModule } from '@uirouter/angular';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import {AppComponent} from './app.component';
import {NavComponent} from './nav/nav.component';

import { appRoutes } from './routes';
import { Ticket } from './beans/Ticket';
import { User } from './beans/User';
import { LoginComponent } from './Components/login/login.component';
import { WelcomeBannerComponent } from './Components/welcomeBanner/welcomeBanner.component';
import { BannerComponent } from './Components/Banner/banner.component';
import { MyTicketsComponent } from './Components/myTickets/myTickets.component';
import { NewTicketComponent } from './Components/newticket/newticket.component';
import { NewUserComponent } from './Components/newuser/newuser.component';
import { NotMyTicketsComponent } from './Components/notmytickets/notmytickets.component';
import { FilterPipe } from './pipes/filterpipe';

@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    NgbModule.forRoot(),
    RouterModule.forRoot(appRoutes),
    FormsModule
  ],
  declarations: [
    AppComponent,
    NavComponent,
    LoginComponent,
    WelcomeBannerComponent,
    BannerComponent,
    MyTicketsComponent,
    NewTicketComponent,
    NewUserComponent,
    NotMyTicketsComponent,
    FilterPipe,
   ],
  providers: [

   ],
   exports: [
     FilterPipe
   ],
  bootstrap: [AppComponent]
})
export class AppModule { }
