import {Pipe, PipeTransform} from '@angular/core';
@Pipe({
  name: 'weak'
})
export class WeakHeroPipe implements PipeTransform {
  transform(heros) {
    return heros.filter( hero => hero.powerRating < 9000);
  }
}
