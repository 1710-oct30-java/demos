import { Component,  OnInit, Inject } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs';
import { Bean } from './beans/Bean';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  beans: Array<Bean> = [];

  constructor(@Inject(Http) public http: Http) {

  }

  ngOnInit() {

    this.http.get('http://localhost:8080/bean-project/beans', { withCredentials: true }).subscribe(
      (successResp) => {
        this.beans = successResp.json();
      },
      (failResp) => {
        alert('failed to load beans');
      }
    )

    // // called after the constructor and called  after the first ngOnChanges()
    // const bean1 = new Bean();
    // bean1.name = 'string';
    // bean1.color = 'green';

    // const bean2 = new Bean();
    // bean2.name = 'pinto';
    // bean2.color = 'tan';

    // const bean3 = new Bean();
    // bean3.name = 'coffee';
    // bean3.color = 'black';

    // this.beans.push(bean1);
    // this.beans.push(bean2);
    // this.beans.push(bean3);
  }

}
