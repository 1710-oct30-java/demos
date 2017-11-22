import { Component } from '@angular/core';

@Component({
  selector: 'app-event-binding',
  templateUrl: './event-binding.component.html'
})
export class EventBindingComponent {
  public counter = 0;

  public incrementCounter() {
    this.counter++;
  }
}
