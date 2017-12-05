import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { UIRouterModule } from '@uirouter/angular';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

// componenets
import {AppComponent} from './app.component';
import {NavComponent} from './nav/nav.component';
import {PipeDemoComponent} from './components/pipe-demo/pipe-demo.component';
import {HomeComponent} from './components/home/home.component';
import {HomeChild1Component} from './components/child1/child1.component';
import {HomeChild2Component} from './components/child2/child2.component';

// services
import {SuperHeroService} from './services/super-hero.service';

// pipes
import {StrongHeroPipe} from './pipes/strong-hero.pipe';

import { appRoutes } from './routes';

@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    NgbModule.forRoot(),
    RouterModule.forRoot(appRoutes),
    FormsModule
  ],
  declarations: [
    // components
    AppComponent,
    NavComponent,
    PipeDemoComponent,
    HomeComponent,
    HomeChild1Component,
    HomeChild2Component,

    // pipes
    StrongHeroPipe,
   ],
  providers: [
    // services
    SuperHeroService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
