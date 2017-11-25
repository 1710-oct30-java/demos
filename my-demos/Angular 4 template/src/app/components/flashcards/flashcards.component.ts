import { Component,  OnInit } from '@angular/core';
import {Flashcard} from '../../beans/Flashcard';

@Component({
  selector: 'app-flashcards',
  templateUrl: './flashcards.component.html',
  styleUrls: ['./flashcards.component.css']
})
export class FlashcardComponent implements OnInit {
        flashcards: Array<Flashcard>;
        newCard = new Flashcard();

        constructor() {
        }
        ngOnInit() {
            this.flashcards = [
                {
                    question: 'what is angular',
                    answer: 'angular is a client side framework developed by google',
                    show: false
                },
                {
                    question: 'what is typescript',
                    answer: 'typescript is a super set of javascript that allows types',
                    show: false
                },
                {
                    question: 'what is a structural directive',
                    answer: 'a structural directive is a directive that manipulates the layout',
                    show: false
                }
            ];
        }

        toggle(flashcard) {
            flashcard.show = !flashcard.show;
        }

        addNewCard() {
            this.flashcards.push(this.newCard);
            this.newCard = {
                question: '',
                answer: '',
                show: false
            };
        }

        remove(flashcard) {
            this.flashcards = this.flashcards.filter( (element) => {
            return element !== flashcard;
        });
    }
}
