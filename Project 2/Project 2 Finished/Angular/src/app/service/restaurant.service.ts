import { Injectable, Inject } from '@angular/core';
import { Http } from '@angular/http';

import 'rxjs/Rx';
import { Observable } from 'rxjs/Observable';

import { User } from '../components/beans/User';
import { Cred } from '../components/beans/Cred';

import { environment } from '../../environments/environment';
import { Restaurant } from '../components/beans/Restaurant';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { Review } from '../components/beans/Review';
// import {API_URL} from '../../app.component';

@Injectable()
export class RestaurantService {

    private dataSubject = new BehaviorSubject([]);
    data$: Observable<any> = this.dataSubject.asObservable();
    public restaurants;
    private prom;
    id: number;

    restaurantExists = false;


    constructor(@Inject(Http) public http: Http) {
        // this.getRestaurantById(); //CHANGE THIS TO NOT HARDCODED
    }

    private static handleError(error: any) {
        const errorMessage = (error.message) ? error.message :
            error.status ? `${error.status} - ${error.statusText}` : `Server error`;
        console.log(errorMessage);
        return Observable.throw(errorMessage);
    }
    setId(id: number) {
        console.log('setting id with ' +id);
        this.id = id;
        console.log('this id is ' +this.id);
    }
    getRestaurants() {
        return this.restaurants;
    }

    getRestaurantById(id: number): void {
        console.log(id);
        this.restaurants = this.http.get(environment.context + 'restaurants/get/' + id).map(
            response => response.json(),
            err => console.log(err)
        )
        .subscribe( resp => {
            this.dataSubject.next(resp);
        },
        err => {
            console.log('error occured while loading restaurants' + err);
        }
    );
    }

    addReview(review: Review): Observable<boolean> {
        console.log('called restaurant service addReview');
        return this.http.post(environment.context + 'restaurants/addReview', review)
        .map(resp => resp.json())
        .map((currentReview: Review) => {
            if (!Review.isNull(currentReview)) {
                return true;
            } else {
                return false;
            }
        });
    }


    testGet(id : number) {
        return this.http.get(environment.context +'restaurants/get/' + id)
            .map((response) => {
                // login successful if there's a jwt token in the response
                let retUser = response.json();
                // if (user && user.token) 
                if (retUser){
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    sessionStorage.setItem('currentRest', JSON.stringify(retUser));
                }
            });
    }

}
