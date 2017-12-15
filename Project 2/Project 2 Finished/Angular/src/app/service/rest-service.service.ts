import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Restaurant } from '../components/beans/Restaurant';
import { environment } from '../../environments/environment';
import { Review } from '../components/beans/Review';

@Injectable()
export class RestService {

  constructor(private http: Http) { }

  restaurants: Array<Restaurant>;

  getAllRestaurant() {
    return this.http.get(environment.context + 'restaurants/all')
      .map(response => {
        this.restaurants = response.json(),
          sessionStorage.setItem('allRestaurants', JSON.stringify(this.restaurants));
      },
      err => console.log(err))
  }


  getRestaurantById(id: number) {
    console.log('get rest id of ' + id);
    return this.http.get(environment.context + 'restaurants/get/' + id)
      .map((response) => {
        // login successful if there's a jwt token in the response
        let retUser = response.json();
        console.log(JSON.stringify(retUser));
        // if (user && user.token) 
        if (retUser) {
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          sessionStorage.setItem('currentRestaurant', JSON.stringify(retUser));
        }
      });
  }


  getRestReview(id: number) {
    let currRest: Restaurant = JSON.parse(sessionStorage.getItem('currentRestaurant'));
    console.log(environment.context + 'restaurants/getReviews/' + id);
    return this.http.post(environment.context + 'restaurants/getReviews/'+ id, currRest.name)
      .map(
        (response: Response) => {

          let retUser = response.json();
          console.log('review is ' + JSON.stringify(retUser));
          if (retUser) {
            sessionStorage.setItem('restReviews', JSON.stringify(retUser));
          }
        },
        (err) => {
          console.log(err);
        });
  }


  addReview(review: Review, uId: number, rId: number) {
    console.log('called restService addReview');
    return this.http.post(environment.context + 'restaurants/addReview/' + uId +'/' +rId, review)
    .map(resp => resp.json())
    .map((currentReview: Review) => {
        if (!Review.isNull(currentReview)) {
            return true;
        } else {
            return false;
        }
    });
}


}
