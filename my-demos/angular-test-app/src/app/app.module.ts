// modules
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

// components
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';

// user components
import { UserNavComponent } from './user/nav/nav.component';

// routes
import { appRoutes } from './app.routes';
import { UserComponent } from './user/user.component';
import { HomeComponent } from './user/home/home.component';
import { TestComponent } from './test/test.component';
import { QuestionComponent } from './test/question/question.component';
import { HttpTestsComponent } from './user/http-tests/http-tests.component';
import { HttpDemosComponent } from './http-demos/http-demos.component';


@NgModule({
  declarations: [
    AppComponent,

    //user components
    UserNavComponent,

    LoginComponent,

    UserComponent,

    HomeComponent,

    TestComponent,

    QuestionComponent,

    HttpTestsComponent,

    HttpDemosComponent
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
