import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http/';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'app-http-tests',
  templateUrl: './http-tests.component.html',
  styleUrls: ['./http-tests.component.css']
})
export class HttpTestsComponent implements OnInit {

  constructor(private http: Http) { }

  ngOnInit() {
    this.http.get(environment.context + "users",{ withCredentials: true})
    .subscribe((sucResp) => {
      console.log(sucResp.json());
    });
  }

}
