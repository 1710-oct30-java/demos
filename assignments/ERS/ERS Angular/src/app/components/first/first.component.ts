import { Component,  OnInit } from '@angular/core';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent implements OnInit {

    counter = 0;

    person = {
        name: 'Kelton',
        hairColor: 'blonde'
    };

    constructor() {
          
    }

    ngOnInit() {

    }

    increment(amt) {
        this.counter+= amt;
    }
    
    changeName(){
        this.person.name = this.person.name.substring(0, this.person.name.length - 1);
    }
}
