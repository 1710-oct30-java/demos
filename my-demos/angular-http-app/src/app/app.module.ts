import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { UIRouterModule } from '@uirouter/angular';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import {AppComponent} from './app.component';
import {NavComponent} from './nav/nav.component';
import {FlashCardsComponent} from './components/flashcard/flashcards.component';
import {BeanComponent} from './components/bean/bean.component';
import {PokemonComponent} from './components/pokemon/pokemon.component';

import { appRoutes } from './routes';
import { ReimbursementComponent } from './components/reimbursement/reimbursement.component';
import { Reimbursement } from './components/beans/reimbursement';

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
    FlashCardsComponent,
    BeanComponent,
    PokemonComponent,
    ReimbursementComponent
   ],
  providers: [

   ],
  bootstrap: [AppComponent]
})
export class AppModule { }
