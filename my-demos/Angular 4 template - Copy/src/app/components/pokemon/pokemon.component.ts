import { Component, OnInit, Inject } from '@angular/core';
import { Http } from '@angular/http';
import {Observable} from 'rxjs/Observable';

@Component({
 selector: 'app-pokemon',
 templateUrl: './pokemon.component.html',
 styleUrls: ['./pokemon.component.css']
})
export class PokemonComponent implements OnInit {
  pokemon: any;

 // used for setting field values
 constructor(@Inject(Http) public http: Http) {

 }
 // on for actual initializations
 ngOnInit() {
  const observable = this.http.get('https://pokeapi.co/api/v2/pokemon-form/778/');
  observable.subscribe( (successResponse) => {
    this.pokemon.name = successResponse.json();
  }, (failResponse) => {
    alert('failed');
  });
 }

}
