import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment';


@Component({
  selector: 'app-http-demos',
  templateUrl: './http-demos.component.html',
  styleUrls: ['./http-demos.component.css']
})
export class HttpDemosComponent implements OnInit {
  data;

  constructor(public http: Http) { }

  ngOnInit() {
                    // localhost/
      this.http.get(environment.bootContext + 'users', {withCredentials: true})
        .subscribe( (successResp) => {
          console.log(successResp.json());
          this.data = successResp.json();
        },
        (errResp) => {
          console.log(errResp.text());
        });

  }

}
