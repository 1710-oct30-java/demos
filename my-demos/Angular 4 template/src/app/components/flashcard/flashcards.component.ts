import { Component, OnInit } from '@angular/core';
import {Flashcard} from '../beans/flashcard.component';
@Component({
 selector: 'app-flashcards',
 templateUrl: './flashcards.component.html',
 styleUrls: ['./flashcards.component.css']
})
export class FlashCardsComponent implements OnInit {

 flashcards: Array<Flashcard>;
 newCard = new Flashcard();
 // used for setting field values
 constructor() {

 }
 // on for actual initializations
 ngOnInit() {
   this.flashcards = [
     {
       question: 'what is angular',
       answer: 'angular is a clientside framework developed by Google',
       show: false
     },
     {
       question: 'what is TypeScript',
       answer: 'TypeScript is a super set of JS that allows types',
       show: false
     },
     {
       question: 'What is a structural directive',
       answer: 'A structural directive is a directive that manipulates the layout of the DOM',
       show: false
     }
   ];
 }
 toggle(flashcard) {
   flashcard.show = !flashcard.show;
 }
 addNewCard() {
   this.flashcards.push(this.newCard);
   this.newCard = new Flashcard();
 }
 removeRandom() {
   const rand = Math.floor(Math.random() * this.flashcards.length);
   this.flashcards.splice(rand, 1);
 }
}
