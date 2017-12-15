import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { environment } from '../../environments/environment';
import { User } from '../components/beans/User';


@Injectable()
export class ControlPanelService {

  constructor(private http: Http) { }

  updateInfo(user: User) {
    console.log(user);
    return this.http.post(environment.context + 'cpanel/update/info', user)
      .map((response: Response) => {
        // login successful if there's a jwt token in the response
        let retUser = response.json();
        // if (user && user.token) 
        if (retUser) {
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          sessionStorage.setItem('currentUser', JSON.stringify(retUser));
        }
      });
  }

  updatePass(user: User) {
    console.log(user);
    return this.http.post(environment.context + 'cpanel/update/pass', user)
      .map((response: Response) => {
        // login successful if there's a jwt token in the response
        let retUser = response.json();
        // if (user && user.token) 
        if (retUser) {
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          sessionStorage.setItem('currentUser', JSON.stringify(retUser));
        }
      });
  }

  // getReviewByUser() {
  //     let user: User = JSON.parse(sessionStorage.getItem('currentUser'));
  //     let id = user.userId;
  //     console.log(environment.context + 'users/getReviews/' + id);
  //     return this.http.get(environment.context + 'users/getReviews/'+ id)
  //       .map(
  //         (response: Response) => {

  //           let retUser = response.json();
  //           console.log('review is ' + JSON.stringify(retUser));
  //           if (retUser) {
  //             sessionStorage.setItem('userReviews', JSON.stringify(retUser));
  //           }
  //         },
  //         (err) => {
  //           console.log(err);
  //         });
  //   }

  getReviewByUser() {
    let user: User = JSON.parse(sessionStorage.getItem('currentUser'));
    let id = user.userId;
    console.log(environment.context + 'cpanel/allUserReviews/'+id);
    return this.http.post(environment.context + 'cpanel/allUserReviews/' + id, user.username)
      .map(
      (response: Response) => {

        let retUser = response.json();
        console.log('review is ' + JSON.stringify(retUser));
        if (retUser) {
          sessionStorage.setItem('userReviews', JSON.stringify(retUser));
        }
      },
      (err) => {
        console.log(err);
      });
  }


  getReviewByUserId(someId: number, username: String) {
    console.log(environment.context + 'cpanel/allUserReviews/'+someId);
    return this.http.post(environment.context + 'cpanel/allUserReviews/' + someId, username)
      .map(
      (response: Response) => {

        let retUser = response.json();
        console.log('review for '+username+' is ' + JSON.stringify(retUser));
        if (retUser) {
          sessionStorage.setItem('someUserReviews', JSON.stringify(retUser));
        }
      },
      (err) => {
        console.log(err);
      });
  }
  

}
