import { OnInit, Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'
import { environment } from '../../environments/environment';
import { User } from '../components/beans/User';
import { RequestOptions } from '@angular/http';

@Injectable()
export class AuthService implements OnInit{
    constructor(private http: Http) { }

    ngOnInit() {
        // this.data.currentUser.subscribe(message => this.message = message)
    }

    login(user : User) {
        return this.http.post(environment.context +'users/login', user)
            .map((response: Response) => {
                // login successful if there's a jwt token in the response
                let retUser = response.json();
                // if (user && user.token) 
                if (retUser){
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    sessionStorage.setItem('currentUser', JSON.stringify(retUser));
                }
            });
    }
    newMessage() {
        
      }

    logout() {
        // remove user from local storage to log user out
        sessionStorage.removeItem('currentUser');
    }

    register(user : User) {
        return this.http.post(environment.context + 'users/register', user, this.jwt()).map((response: Response) => response.json());
    }

    private jwt() {
        // create authorization header with jwt token
        let currentUser = JSON.parse(sessionStorage.getItem('currentUser'));
        if (currentUser && currentUser.token) {
            let headers = new Headers({ 'Authorization': 'Bearer ' + currentUser.token });
            return new RequestOptions({ headers: headers });
        }
    }
}