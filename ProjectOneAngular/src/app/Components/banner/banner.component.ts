import { Component, OnInit, Inject } from '@angular/core';
import { User } from '../../beans/User';
import { Http } from '@angular/http';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.css']
})
export class BannerComponent {

  currUser = new User();

  constructor() {
  }

  welcome() {
    this.currUser = JSON.parse((sessionStorage.getItem('user')));
    document.getElementById('welcomeName').innerText += ' ' + (this.currUser.firstName) + ' ' + (this.currUser.lastName);
  }

  logout() {
    sessionStorage.setItem('user', '');
    document.getElementById('logInApp').hidden = false;
    document.getElementById('welcomeBanner').hidden = false;
    document.getElementById('banner').hidden = true;
    document.getElementById('mytickets').hidden = true;
    document.getElementById('mylist').hidden = true;
    document.getElementById('newticket').hidden = true;
    document.getElementById('notmytickets').hidden = true;
    document.getElementById('loading').hidden = true;
    document.getElementById('loading2').hidden = true;
    document.getElementById('notmylist').hidden = true;
    document.getElementById('ct').hidden = true;
  }
}
