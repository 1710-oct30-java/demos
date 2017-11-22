import { Component,  OnInit } from '@angular/core';

@Component({
  selector: 'app-another',
  templateUrl: './another.component.html',
  styleUrls: ['./another.component.css']
})
export class AnotherComponent implements OnInit {

    someField = 'hello';

    constructor() {

    }

    ngOnInit() {
    }
}
