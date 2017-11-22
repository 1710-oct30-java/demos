import { Component } from '@angular/core';

@Component({
  selector: 'app-child1',
  templateUrl: './child1.component.html',
  styleUrls: ['./child1.component.css'],
})
export class Child1Component {
  public someField = {
    name: 'blake'
  };

  public simple = 'c1';

  public myClick() {
    if (this.simple === 'c1') {
      this.simple = 'c2';
    } else {
      this.simple = 'c1';
    }
  }
}
