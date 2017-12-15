import { Component,  OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor(private router: Router) {
  }

  ngOnInit()  {
    // called after the constructor and called  after the first ngOnChanges()
    this.router.navigate(['']);
  }


}
