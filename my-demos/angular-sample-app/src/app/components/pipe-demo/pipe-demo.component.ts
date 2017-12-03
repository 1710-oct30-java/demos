import { Component } from '@angular/core';

@Component({
  selector: 'app-pipe-demo',
  templateUrl: './pipe-demo.component.html',
})
export class PipeDemoComponent {
  str = 'hello world';
  today = new Date();
}
