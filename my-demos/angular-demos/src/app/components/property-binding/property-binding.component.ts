import { Component } from '@angular/core';

@Component({
  selector: 'app-property-binding',
  templateUrl: './property-binding.component.html'
})
export class PropertyBindingComponent {
  public flash = {
    question: 'What is property binding?',
    answer: `Write a template property binding to set a property of a view element. The binding sets
the property to the value of a template expression.

It can also be used to provide input to child components`
  };

  public styleObject = {
    color: 'red',
    border: '1px solid black',
    cursor: 'pointer',
    margin: '2em',
  };

  public changeStyles() {
    if (this.styleObject.color === 'red') {
      this.styleObject.color = 'blue';
      this.styleObject.border = '2px groove purple';
    } else if (this.styleObject.color === 'blue') {
      this.styleObject.color = 'green';
      this.styleObject.border = '3px ridge yellow';
    } else {
      this.styleObject.color = 'red';
      this.styleObject.border = '1px solid black';
    }
  }
}
