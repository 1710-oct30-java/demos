import { Component } from '@angular/core';

@Component({
  selector: 'app-structural-directive',
  templateUrl: './structural-directive.component.html'
})
export class StructuralDirectiveComponent {
  // not done yet
  public flashcards = [
    {
      question: 'question 1',
      answer: 'answer to q1',
      completed: false
    },
    {
      question: 'this is my qauestsion',
      answer: 'this is the answer',
      completed: false
    },
    {
      question: 'question 2',
      answer: 'answer to q2',
      completed: true
    },
    {
      question: 'question 3',
      answer: 'answer to q3',
      completed: false
    }
  ];

  public filterCompleted = false;

  public toggleCompleted() {
    this.filterCompleted = !this.filterCompleted;
  }
}
