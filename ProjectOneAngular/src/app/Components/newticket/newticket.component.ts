import { Component, OnInit, Inject, Directive } from '@angular/core';
import { Ticket } from '../../beans/Ticket';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { BannerComponent } from '../banner/banner.component';
import { MyTicketsComponent } from '../myTickets/myTickets.component';


@Component({
  selector: 'app-newticket',
  templateUrl: './newticket.component.html',
  styleUrls: ['./newticket.component.css']
})

export class NewTicketComponent implements OnInit {

  newTicket = new Ticket();
  receiptF: File;

  constructor( @Inject(Http) public http: Http) {

  }

  ngOnInit() {

  }

  submitNewTicket() {
    this.newTicket.author = JSON.parse((sessionStorage.getItem('user')));

    this.http.post('http://localhost:8080/ERS/reimbursement/new', JSON.stringify(this.newTicket), { withCredentials: true }).subscribe(
      (successResp) => {
        alert('Added New Ticket');
      },
      (failResp) => {
        alert('Failed Add New Ticket');
      }
    );
  }

  onChange(event: EventTarget) {
    let eventObj: MSInputMethodContext = <MSInputMethodContext> event;
    let target: HTMLInputElement = <HTMLInputElement> eventObj.target;
    let files: FileList = target.files;
    this.receiptF = files[0];
    console.log(this.receiptF);
    // this.newTicket.receipt = new Blob([this.receiptF]);
    console.log(this.newTicket.receipt);
  }

  toggle() {
    document.getElementById('ct').hidden = !document.getElementById('ct').hidden;
    document.getElementById('mylist').hidden = true;
    document.getElementById('notmylist').hidden = true;
  }
}
