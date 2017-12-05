import { Component } from '@angular/core';

@Component({
  selector: 'app-pipes',
  templateUrl: './pipes.component.html'
})
export class PipesComponent {
  currentTime: Date;

  constructor() {
    setInterval(() => { this.currentTime = new Date(); }, 1000);
  }
}
