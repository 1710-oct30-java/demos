import { Component,  OnInit, Inject } from '@angular/core';
import { Http } from '@angular/http';
import {Observable} from 'rxjs/Observable'


@Component({
  selector: 'app-pokemon',
  templateUrl: './pokemon.component.html',
  styleUrls: ['./pokemon.component.css']
})
export class PokemonComponent implements OnInit {
  pokemon: any;
  secondSubscriber: any;

  constructor(@Inject(Http) public http: Http) {

  }

  ngOnInit() {
    const observable = this.http.get('https://pokeapi.co/api/v2/pokemon/4');
    observable.subscribe( (successResponse) => {
      this.pokemon = successResponse.json();
    }, (failResponse) => {
      alert('failed');
    });

    // we don't really need it but we can have multiple subscriptions
    observable.subscribe ( (successResponse) => {
      this.secondSubscriber = successResponse.json();
      this.secondSubscriber.name += 'edited';
    })
  }
}
