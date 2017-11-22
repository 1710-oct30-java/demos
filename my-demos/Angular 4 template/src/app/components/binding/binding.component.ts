import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-binding',
    templateUrl: './binding.component.html',
    styleUrls: ['./binding.component.css']
})
export class Binding implements OnInit {
    person = {
        name: 'Santosh',
        hairColor: 'Black'
    };

    counter = 0;

    constructor() {

    }

    ngOnInit() {

    }

    increment() {
        this.counter++;
    }

    superIncrement() {
        this.counter++;
    }
}
