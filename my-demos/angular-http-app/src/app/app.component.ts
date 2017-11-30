import { Component,  OnInit, Inject } from '@angular/core';
import { Http } from '@angular/http';
// tslint:disable-next-line:import-blacklist
import { Observable } from 'rxjs';
import { Reimbursement } from './components/beans/reimbursement';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  reimbursements: Array<Reimbursement> = [];


  constructor(@Inject(Http) public http: Http) {

  }

  ngOnInit() {

    this.http.get('http://localhost:8080/ERSProject/users/manager/viewrequests/all').subscribe(
      (successResp) => {
        this.reimbursements = successResp.json();
      },
      (failResp) => {
        alert('failed to load reimbursements');
      }
    );

  }

}
