import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { OnInit } from '@angular/core';
import { RestService } from './rest-service.service';
import { Restaurant } from '../components/beans/Restaurant';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs/Subject';



@Injectable()
export class MapService implements OnInit {

    restaurants: Array<Restaurant>;
    temp : Array<marker>;
    private markers = new Subject<any>();
  constructor(private restService: RestService) { }

  ngOnInit() {
    this.restaurants = JSON.parse(sessionStorage.getItem('allRestaurants'));
    this.temp = new Array<marker>();
}


  getRestMarkers() : Observable<any>{
      console.log('getting markers')
    for (let rest of this.restaurants) {
        this.temp.push({
            lat: 28.0720588 + rest.restaruantId,
            lng: -82.4284711 + rest.restaruantId,
            label: rest.restaruantId.toString(),
            draggable: false
        })
    }
    this.markers.next(this.temp);
    console.log('from service '+ this.temp)
    return this.markers.asObservable();
  }



}

interface marker {
    lat: number;
    lng: number;
    label?: String;
    draggable: boolean;
  }
