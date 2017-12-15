import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../components/beans/Restaurant';
import { Router } from '@angular/router';
import { RestService } from '../service/rest-service.service';

@Component({
  selector: 'app-restaurants',
  templateUrl: './restaurants.component.html',
  styleUrls: ['./restaurants.component.css']
})
export class RestaurantsComponent implements OnInit {

  constructor(private restService: RestService,
    private router: Router) { }

  allRestaurants: Array<Restaurant>;

  ngOnInit() {
    this.allRestaurants = JSON.parse(sessionStorage.getItem('allRestaurants'));
  }
  restChosen(id: number) {
    console.log('called choose ts for id' + id);
    this.router.navigate(['/add', id]);
  }




}
