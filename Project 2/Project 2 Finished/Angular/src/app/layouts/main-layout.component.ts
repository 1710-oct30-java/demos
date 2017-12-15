import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-layout',
  template: `
  <app-nav></app-nav>
  <router-outlet></router-outlet>
  
`,
styles: []
})
export class MainLayoutComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
