import {Pipe, PipeTransform} from '@angular/core';
@Pipe({
  name: 'strong'
})
export class StrongHeroPipe implements PipeTransform {
  transform(heros) {
    return heros.filter( hero => hero.powerRating > 9000);
  }
}
