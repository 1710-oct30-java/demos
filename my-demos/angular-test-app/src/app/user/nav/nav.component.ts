import { Component } from '@angular/core';

@Component({
  selector: 'app-user-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class UserNavComponent {
  collapsed = true;

  toggleCollapse() {
    this.collapsed = !this.collapsed;
  }
}
