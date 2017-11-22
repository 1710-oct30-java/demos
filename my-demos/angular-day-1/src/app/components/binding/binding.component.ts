import { Component,  OnInit } from '@angular/core';

@Component({
  selector: 'app-binding',
  templateUrl: './binding.component.html',
  styleUrls: ['./binding.component.css']
})
export class BindingComponent implements OnInit {

  person = {
    name: 'blake',
    hairColor: 'blonde'
  };

  counter = 0;

  constructor() {

  }

  ngOnInit() {

  }

  increment() {
    this.counter++;
  }

  getName() {
    alert(this.person.name);
  }

  resetName() {
    this.person.name = 'blake';
  }
}
