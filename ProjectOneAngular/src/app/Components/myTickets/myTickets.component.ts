import { Component, OnInit, Inject } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Ticket } from '../../beans/Ticket';
import { User } from '../../beans/User';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-mytickets',
  templateUrl: './myTickets.component.html',
  styleUrls: ['./myTickets.component.css']
})

export class MyTicketsComponent implements OnInit {

  tickets: Array<Ticket> = [];
  currUser = new User();

  params: URLSearchParams = new URLSearchParams();

  constructor(public http: Http) {

  }

  ngOnInit() {
  }

  reinitalize() {
    this.currUser = JSON.parse((sessionStorage.getItem('user')));
    let x = 'http://localhost:8080/ERS/reimbursement/getByUser/';
    x += '?userId=' + this.currUser.userID;

    document.getElementById('loading').hidden = !document.getElementById('loading').hidden;
    this.http.get(x, { withCredentials: true }).subscribe(
      (successResp) => {
        this.tickets = successResp.json();
        document.getElementById('loading').hidden = !document.getElementById('loading').hidden;
      },
      (failResp) => {
        alert('Failed to retrieve tickets');
      }
    );
  }

  toggle(fc) {
    document.getElementById('mylist').hidden = !document.getElementById('mylist').hidden;
    document.getElementById('ct').hidden = true;
    document.getElementById('notmylist').hidden = true;
  }
}
