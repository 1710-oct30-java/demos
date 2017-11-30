import { Component,  OnInit, Inject } from '@angular/core';
import { Http } from '@angular/http';
// tslint:disable-next-line:import-blacklist
import { Observable } from 'rxjs';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {


  constructor(@Inject(Http) public http: Http) {
  }

  ngOnInit()  {
    this.http.get('http://localhost:8080/ERSProject/users/reimbursements/viewpastreimbursements').subscribe(
      (successResp) => {
      },
      (failResp) => {
        alert('failed to load reimbursements');
      }
    );

  }

  change() {
  }
}
