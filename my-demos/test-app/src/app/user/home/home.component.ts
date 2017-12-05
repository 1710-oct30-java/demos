import { Component, OnInit } from '@angular/core';
import { Test } from '../../entities/test';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  tests: Array<Test>;

  constructor() { }

  ngOnInit() {
    this.tests = [
      {
        id: 1,
        title: 'Java Test',
        questions: [
          {
            id: 1,
            question: 'question 1',
            answers: [
              'answer 0',
              'answer 1',
              'answer 2',
              'answer 3'
            ],
            correctAnswer: 0,
            selectAnswer: undefined
          }
        ]
      },
      {
        id: 2,
        title: 'JS test',
        questions: [
          {
            id: 1,
            question: 'question 1',
            answers: [
              'answer 0',
              'answer 1',
              'answer 2',
              'answer 3'
            ],
            correctAnswer: 0,
            selectAnswer: undefined
          }
        ]
      }
    ];
  }

}
