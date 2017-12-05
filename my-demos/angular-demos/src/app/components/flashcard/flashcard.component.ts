import { Component, Input } from '@angular/core';
import { Flashcard } from '../../beans/flashcard';

@Component({
  selector: 'app-flashcard',
  templateUrl: './flashcard.component.html',
  styleUrls: ['flashcard.component.css']
})
export class FlashcardComponent {
  @Input()
  public flashcard: Flashcard;
  public display = false;

  public toggleAnswer() {
    this.display = !this.display;
    this.flashcard = {
      id: 5,
      question: 'hello',
      answer: 'world'
    }
  }
}

