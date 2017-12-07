import { Component, OnInit } from '@angular/core';
import { Test } from '../entities/test';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {
  tests: Array<Test>;
  id: Number;
  test: Test;
  constructor(public route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.id = params['id'];
    });

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
          },
          {
            id: 2,
            question: 'question 2',
            answers: [
              'answer 0',
              'answer 1',
              'answer 2',
              'answer 3'
            ],
            correctAnswer: 0,
            selectAnswer: undefined
          },
          {
            id: 3,
            question: 'question 3',
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

    this.test = this.tests.filter((test) => test.id == this.id)[0];
    // alert(this.test)
  }

}
