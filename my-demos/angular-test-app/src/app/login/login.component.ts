import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  credential = {
    username: '',
    password: '',
  };

  constructor(private router: Router, private http: Http) { }

  ngOnInit() {
  }

  submit() {

    this.http.post(environment.context + 'users/login', this.credential, {withCredentials: true})
      .subscribe( (succResp) => {
        if (succResp.text() !== '') {
          this.router.navigateByUrl('/user/home');
        } else {
          alert('failed to login');
        }
      });
  }

}
