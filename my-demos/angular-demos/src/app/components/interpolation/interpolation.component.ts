import { Component } from '@angular/core';

@Component({
  selector: 'app-interpolation',
  templateUrl: './interpolation.component.html'
})
export class InterpolationComponent {
  public interpolate = '{{ }} will bind the view to data from the component class'
  public someField = {
    id: 1,
    fname: 'Blake',
    lname: 'Kruppa'
  };
}
