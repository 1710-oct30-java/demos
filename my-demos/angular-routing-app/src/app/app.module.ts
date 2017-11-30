import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { UIRouterModule } from '@uirouter/angular';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import {AppComponent} from './app.component';
import {NavComponent} from './nav/nav.component';
import {PipeComponent} from './components/pipe-demo/pipe-demo.component';
import {HomeComponent} from './components/home/home.component';

import { appRoutes } from './routes';
import { Child1Component } from './components/child1/child1.component';
import { Child2Component } from './components/child2/child2.component';
import { SuperHeroService } from './services/super-hero.service';
import { StrongHeroPipe } from './components/pipe-demo/strong-pipe';
import { WeakHeroPipe } from './components/pipe-demo/weak-pipe';

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
    PipeComponent,
    HomeComponent,
    Child1Component,
    Child2Component,
    StrongHeroPipe,
    WeakHeroPipe
   ],
  providers: [
    SuperHeroService
   ],
  bootstrap: [AppComponent]
})
export class AppModule { }
