import { Component, OnInit, NgModule } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from '../../../environments/environment';
import { User } from '../beans/User';

import {
  BrowserModule
} from '@angular/platform-browser';

import {
  AgmCoreModule
} from '@agm/core';
import { Restaurant } from '../beans/Restaurant';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';
import { MapService } from '../../service/map.service';
import { Marker } from '@ngui/map/dist/directives/marker';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent {

  public positions= [];

    constructor() {
      this.positions = this.getRandomMarkers();
  
    }
    
    onMapReady(map) {
      console.log('map', map);
      console.log('markers', map.markers);  // to get all markers as an array 
    }
  
    getRandomMarkers() {
      let randomLat: number, randomLng: number;
  
      let positions = [];
      for (let i = 0 ; i < 9; i++) {
        randomLat = Math.random() * (43.7399 - 43.7300) + 28.0584618;
        randomLng = Math.random() * (-79.7600 - -79.7699) + -82.4095894;
        positions.push([randomLat, randomLng]);
      }
      return positions;
    }
  
    showMarkersFromObservable() {
      Observable.of(this.getRandomMarkers()) // Think this as http call
        .subscribe( positions => {
          this.positions = positions;
        });
    }

    markerClicked(target: Marker)
    {
      console.log(target);
    }
}
// just an interface for type safety.
// interface marker {
//   lat: number;
//   lng: number;
//   label?: String;
//   draggable: boolean;
// }