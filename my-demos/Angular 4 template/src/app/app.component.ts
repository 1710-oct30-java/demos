import { Component,  OnInit } from '@angular/core';
import { Bean } from './components/beans/bean';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  appComponentBean: Bean;
  bean2: Bean;
  beans: Array<Bean> = [];


  constructor() {
  }

  ngOnInit()  {
    // called after the constructor and called  after the first ngOnChanges()
    const bean1 = new Bean();
    bean1.name = 'pinto';
    bean1.color = 'brown';

    const bean2 = new Bean();
    bean2.name = 'string';
    bean2.color = 'green';

    this.beans.push(bean1);
    this.beans.push(bean2);
  }

  change() {
  }
}
