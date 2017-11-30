import { Component, Inject } from '@angular/core';
import { LoginService } from '../components/login/login.service';
import { User } from '../beans/User';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {
  constructor(@Inject(LoginService) public ls: LoginService) {
    
  }

  ngOnInit() {
    console.log(this.ls.currentUser);
  }

  signOut() {
    this.ls.currentUser = new User("N/A");
    window.location.href = "/login";
  }
}
