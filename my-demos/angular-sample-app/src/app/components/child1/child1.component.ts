import { Component, Inject, OnInit } from '@angular/core';
import { SuperHeroService } from '../../services/super-hero.service';

@Component({
  templateUrl: './child1.component.html',
})
export class HomeChild1Component implements OnInit {
  heroes: Array<any>;

  constructor(@Inject(SuperHeroService) private shs: SuperHeroService) {

  }

  ngOnInit() {
    this.heroes = this.shs.superHeroes;
  }


}
