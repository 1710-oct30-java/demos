// modules
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

// components
import { AppComponent } from './app.component';

// user components
import { UserNavComponent } from './user/nav/nav.component';

// routes
import { appRoutes } from './app.routes';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,

    //user components
    UserNavComponent,

    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    NgbModule.forRoot(),
    RouterModule.forRoot(appRoutes, { useHash: true }),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
