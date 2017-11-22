import { Component, OnInit } from '@angular/core';
import { Bean } from './beans/Bean';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  beans: Array<Bean> = [];


  constructor() {
  }

  ngOnInit() {
    const bean1 = new Bean();
    bean1.Name = 'string';
    bean1.Color = 'green';

    const bean2 = new Bean();
    bean2.Name = 'pinto';
    bean2.Color = 'tan';

    this.beans.push(bean1);
    this.beans.push(bean2);
  }

}
