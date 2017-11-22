import { Component, OnInit } from '@angular/core';
import { FlashCard } from '../../beans/Flashcard';

@Component({
    selector: 'app-flashcards',
    templateUrl: './flashcards.component.html',
    styleUrls: ['./flashcards.component.css']
})
export class Flashcards implements OnInit {
    flashcards: any;
    newCard = new FlashCard();

    ngOnInit() {
        this.flashcards = [
            {
                question: 'What is Angular',
                answer: 'Angular is a client side framework developed by google'
            },
            {
                question: 'What is typeScript',
                answer: 'TypeScript is a super set of javaScript that allow'
            },
            {
                question: 'What is structural directive',
                answer: ' A structural directive is a directive that manipulate DOM'
            }
        ];
    }

    toggle(flashcard) {
        flashcard.show = !flashcard.show;
    }

    addNewCard() {
        this.flashcards.push(this.newCard);
        this.newCard = new FlashCard();
    }
}

