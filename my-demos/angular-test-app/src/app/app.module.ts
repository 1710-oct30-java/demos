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
<<<<<<< HEAD
import { LoginComponent } from './login/login.component';
=======
import { UserComponent } from './user/user.component';
import { HomeComponent } from './user/home/home.component';
import { TestComponent } from './test/test.component';
import { QuestionComponent } from './test/question/question.component';

>>>>>>> 77cbed5c25e0a490dca6d04d6a3493d8bafff454

@NgModule({
  declarations: [
    AppComponent,

    //user components
    UserNavComponent,

<<<<<<< HEAD
    LoginComponent
=======
    LoginComponent,

    UserComponent,

    HomeComponent,

<<<<<<< HEAD:my-demos/test-app/src/app/app.module.ts
    TestComponent
>>>>>>> 77cbed5c25e0a490dca6d04d6a3493d8bafff454
=======
    TestComponent,

    QuestionComponent
>>>>>>> 68cd7019c1c44cdb4cb696cb97dad2f98da1248c:my-demos/angular-test-app/src/app/app.module.ts
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