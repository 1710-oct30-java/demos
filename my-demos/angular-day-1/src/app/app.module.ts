import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import {AppComponent} from './app.component';
import {NavComponent} from './nav/nav.component';
import {FirstComponent} from './components/first/first.component';
import {AnotherComponent} from './components/another/another.component';
import {BindingComponent} from './components/binding/binding.component';
import {FlashcardComponent} from './components/flashcards/flashcards.component';
import {BeanComponent} from './components/bean/bean.component';
import {PokemonComponent} from './components/pokemon/pokemon.component';

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
    // our components
    AppComponent,
    NavComponent,
    FirstComponent,
    AnotherComponent,
    BindingComponent,
    FlashcardComponent,
    BeanComponent,
    PokemonComponent,
   ],
  providers: [

   ],
  bootstrap: [AppComponent]
})
export class AppModule { }
