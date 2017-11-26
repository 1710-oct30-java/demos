import {Injectable, Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'completed'
})
@Injectable()
export class CompletedPipe implements PipeTransform {
  transform(flashcards: any[], enableFlag): any {
    return flashcards.filter(flashcard => (enableFlag && !flashcard.completed) || !enableFlag);
  }
}
