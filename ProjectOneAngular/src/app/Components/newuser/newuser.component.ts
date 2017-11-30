import { Component, OnInit, Inject } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { User } from '../../beans/User';

@Component({
  selector: 'app-newuser',
  templateUrl: './newuser.component.html',
  styleUrls: ['./newuser.component.css']
})

export class NewUserComponent implements OnInit {

  newUser = new User();

  constructor( @Inject(Http) public http: Http ) {

  }

  ngOnInit() {
    this.newUser.role = '1';
  }

  createUser() {
    this.http.post('http://localhost:8080/ERS/users/new', JSON.stringify(this.newUser), { withCredentials: true }).subscribe(
      (successResp) => {
        alert('Creating user with following credentials' + JSON.stringify(this.newUser));

        // Swap out and initalize the nessicary components
        document.getElementById('logInApp').hidden = false;
        document.getElementById('newUserApp').hidden = true;
      },
      (failResp) => {
        alert('Failed Create new user');
      }
    );
  }

  cancel() {
    // Swap out and initalize the nessicary components
    document.getElementById('logInApp').hidden = false;
    document.getElementById('newUserApp').hidden = true;
  }
}
