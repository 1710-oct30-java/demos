import { Component,  OnInit } from '@angular/core';
import {Bean} from './beans/Bean/Bean';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';
  yup: string;

  bean2: Bean;

  constructor() {
  }

  ngOnInit()  {
    // called after the constructor and called  after the first ngOnChanges()
    const bean1 = new Bean();
    bean1.name = 'string';
    bean1.color = 'green';

    const bean2 = new Bean();
    bean2.name = 'pinto';
    bean2.color = 'tan';

    this.bean2 = bean2;
  }

  change() {
    this.yup = 'no';
  }
}
