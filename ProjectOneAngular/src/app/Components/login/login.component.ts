import { Component, OnInit, Inject } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { User } from '../../beans/User';
import { BannerComponent } from '../banner/banner.component';
import { MyTicketsComponent } from '../myTickets/myTickets.component';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  currUser = new User();
  ban = new BannerComponent();

  constructor( @Inject(Http) public http: Http) {

  }

  ngOnInit() {

  }

  login() {
    this.http.post('http://localhost:8080/ERS/users/login', JSON.stringify(this.currUser), { withCredentials: true }).subscribe(
      (successResp) => {
        this.currUser = successResp.json();
        sessionStorage.setItem('user', JSON.stringify(this.currUser));
        // alert(sessionStorage.getItem('user'));

        // Swap out and initalize the nessicary components
        document.getElementById('logInApp').hidden = true;
        document.getElementById('welcomeBanner').hidden = true;
        document.getElementById('banner').hidden = false;
        this.ban.welcome();
        document.getElementById('mytickets').hidden = false;
        document.getElementById('newticket').hidden = false;

        if (this.currUser.role === 'Manager') {
          document.getElementById('notmytickets').hidden = false;
        }
        this.currUser.username = '';
        this.currUser.password = '';
      },
      (failResp) => {
        alert('Failed To Log In');
      }
    );
  }

  createUser() {
    // Swap out and initalize the nessicary components
    document.getElementById('logInApp').hidden = true;
    document.getElementById('newUserApp').hidden = false;
  }
}
