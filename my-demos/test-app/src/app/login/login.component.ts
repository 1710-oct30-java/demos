import { Component, OnInit } from '@angular/core';
<<<<<<< HEAD
=======
import { Router } from '@angular/router';
>>>>>>> 77cbed5c25e0a490dca6d04d6a3493d8bafff454

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
<<<<<<< HEAD
  credentials = {
    email: '',
    password: ''
  };

  constructor() { }
=======
  credential = {
    email: '',
    password: '',
  };

  constructor(public router: Router) { }
>>>>>>> 77cbed5c25e0a490dca6d04d6a3493d8bafff454

  ngOnInit() {
  }

  submit() {
<<<<<<< HEAD
    
=======
    if (this.credential.email === 'user' && this.credential.password === 'pass') {
      this.router.navigateByUrl('/user/home');
    } else {
      alert('login failed');
    }
>>>>>>> 77cbed5c25e0a490dca6d04d6a3493d8bafff454
  }

}
