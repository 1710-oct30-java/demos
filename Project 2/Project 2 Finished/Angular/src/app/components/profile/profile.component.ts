import { Component, OnInit, AnimationTransitionEvent } from '@angular/core';
import { User } from '../beans/User';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: User;
  constructor() {
    this.user = JSON.parse(sessionStorage.getItem('currentUser'));
  }

  ngOnInit() {

  }

}