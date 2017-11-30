import { Component,  OnInit, Inject } from '@angular/core';
import { Http } from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {User} from '../../beans/User';
import {LoginService} from '../login/login.service'
import {trigger, state, style, transition, animate} from '@angular/animations';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  
  animations: [
    trigger('loginState', [
      state('inactive', style({
        opacity: 0,
      })),
      state('active',   style({
        opacity: 1.0,
      })),
      transition('inactive => active', animate('.7s ease-in')),
      transition('active => inactive', animate('.7s ease-out'))
    ])
  ]

})
export class LoginComponent implements OnInit {

    users: Array<User> = new Array<User>();
    state = 'inactive';
    failedLogin = false;

    constructor(@Inject(Http) public http: Http, @Inject(LoginService) private us: LoginService) {

    }

    ngOnInit() {
        
       this.http.get('http://localhost:8080/ERS/users/',  { withCredentials: true }).subscribe(
            (successResponse) => {
                this.users = successResponse.json();
                this.us.allUsers = successResponse.json();
                console.log(this.users);
                this.state = 'active';

       },
            (failResponse) => {
                alert('failed');
       });

       
    }

    toggleState() {
        console.log('toggling');
        this.state = this.state === 'active' ? 'inactive' : 'active';
      }

    attemptLogin(username: string, password: string) {
        
        for (var i = 0; i < this.users.length; i++) {
            let user = this.users[i];
            
            if (user.username == username && user.password == password) {
                this.us.currentUser = user;
                this.failedLogin = false;
                this.toggleState();
                return;
            }
        }

        this.failedLogin = true;
        
    }

}
