import { Component, OnInit, Inject } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Ticket } from '../../beans/Ticket';
import { User } from '../../beans/User';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-notmytickets',
  templateUrl: './notmytickets.component.html',
  styleUrls: ['./notmytickets.component.css']
})

export class NotMyTicketsComponent implements OnInit {

  tickets: Array<Ticket> = [];
  tickets2: Array<Ticket> = [];
  currUser = new User();
  fs: Number;
  currTicket = new Ticket();
  t = new Ticket();

  params: URLSearchParams = new URLSearchParams();

  constructor(public http: Http) {

  }

  ngOnInit() {
  }

  reinitalize() {
    this.currUser = JSON.parse((sessionStorage.getItem('user')));
    let x = 'http://localhost:8080/ERS/reimbursement/getNotMine/';
    x += '?userId=' + this.currUser.userID;

    document.getElementById('loading2').hidden = !document.getElementById('loading').hidden;

    this.http.get(x, { withCredentials: true }).subscribe(
      (successResp) => {
        this.tickets = successResp.json();
        this.tickets2 = successResp.json();
        document.getElementById('loading2').hidden = !document.getElementById('loading2').hidden;
      },
      (failResp) => {
        alert('Failed to retrieve tickets');
      }
    );
  }

  approve(thisTicket) {
    thisTicket.resolver = JSON.parse((sessionStorage.getItem('user')));

    this.http.post('http://localhost:8080/ERS/reimbursement/approve', JSON.stringify(thisTicket), { withCredentials: true }).subscribe(
      (successResp) => {
        alert('Approving Ticket');
      },
      (failResp) => {
        alert('Failed to Approve Ticket');
      }
    );
    this.reinitalize();
  }

  deny(thisTicket) {
    thisTicket.resolver = JSON.parse((sessionStorage.getItem('user')));

    this.http.post('http://localhost:8080/ERS/reimbursement/deny', JSON.stringify(thisTicket), { withCredentials: true }).subscribe(
      (successResp) => {
        alert('Denying Ticket');
      },
      (failResp) => {
        alert('Failed to Deny Ticket');
      }
    );
    this.reinitalize();
  }

  filterTable() {
    if (this.fs === 1) {
      this.tickets2 = this.tickets;
    } else if (this.fs === 2) {
      this.tickets2 = this.tickets.filter(
        t => t.status === 'Pending');
    }else if (this.fs === 3) {
      this.tickets2 = this.tickets.filter(
        t => t.status === 'Approved');
    }else if (this.fs === 4) {
      this.tickets2 = this.tickets.filter(
        t => t.status === 'Denied');
    }
  }

  toggle(fc) {
    document.getElementById('ct').hidden = true;
    document.getElementById('mylist').hidden = true;
    document.getElementById('notmylist').hidden = !document.getElementById('notmylist').hidden;
  }
}
