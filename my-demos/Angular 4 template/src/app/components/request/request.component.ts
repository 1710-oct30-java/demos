import { Component,  OnInit, Inject } from '@angular/core';
import { Http } from '@angular/http';
import {Observable} from 'rxjs/Observable';

@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.css']
})
export class RequestComponent implements OnInit {
    request: any;

    constructor(@Inject(Http) public http: Http) {

    }
    ngOnInit() {
      this.http.get('http://localhost:8080/components/request').subscribe(
              (successResp) => {
                alert('success');
              },
              (failResp) => {
                alert('failed to load beans');
              });
    }
}
