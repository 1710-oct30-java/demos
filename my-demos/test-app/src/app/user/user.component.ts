import { Component, OnInit } from '@angular/core';
import { Test } from '../entities/test';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  tests: Array<Test>;
  constructor() { }

  ngOnInit() {
    this.tests = [
      {
        title: 'JavaTest',
        id: 1,
        questions: [
          {
            id: 1,
            question: 'question1',
            answers:  ['answer 1', 'answer 1 ', 'answer 2', 'answer 4'],
            correctAnswer: 3,
            selectedAnswer: undefined,
          }
        ]
      },
      {
        id: 2,
        title: 'JS Test',
        questions: [
          {
            id: 1,
            question: 'question2',
            answers:  ['answer 1', 'answer 4 ', 'answer 2', 'answer 4'],
            correctAnswer: 1,
            selectedAnswer: undefined,
          }
        ]
      }
    ];
  }

}
