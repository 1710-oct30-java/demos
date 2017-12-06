import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  credential = {
    email: '',
    password: '',
  };

  constructor(public router: Router) { }

  ngOnInit() {
  }

  submit() {
    if (this.credential.email === 'user' && this.credential.password === 'pass') {
      this.router.navigateByUrl('/user/home');
    } else {
      alert('login failed');
    }
  }

}
