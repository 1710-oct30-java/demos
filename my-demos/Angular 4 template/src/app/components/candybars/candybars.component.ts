import { Component,  OnInit } from '@angular/core';

@Component({
  selector: 'app-candybars',
  templateUrl: './candybars.component.html',
  styleUrls: ['./candybars.component.css']
})
export class CandybarComponent implements OnInit {
    candybars: any;

    constructor() {
    }
    ngOnInit() {
        this.candybars = [
            {
                name: 'hershey',
                rating: 6,
                show: false
            },
            {
                name: 'reeses',
                rating: 8,
                show: false
            }
        ];
    }

    toggle(candybars) {
        candybars.show = !candybars.show;
    }
}
