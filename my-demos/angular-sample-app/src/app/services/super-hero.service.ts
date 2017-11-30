import { Injectable } from '@angular/core';

@Injectable()
export class SuperHeroService {
  superHeroes = [
    {
      name: 'Bob Barker',
      power: 'Being Bob Barker',
      powerRating: 2
    },
    {
      name: 'Stan Lee',
      power: 'creating other super heroes',
      powerRating: 9001
    },
    {
      name: 'Goku',
      power: 'Super Saiyan',
      powerRating: 9002
    },
    {
      name: 'Aqua Man',
      power: 'Swimming and being really tan',
      powerRating: 1
    }
  ];
}
