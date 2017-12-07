import { Component, OnInit, Input } from '@angular/core';
import { Question } from '../../entities/Question';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {
  @Input()
  question: Question;
  constructor() { }

  ngOnInit() {
  }

  onSelectionChange(question, answer) {
    // clone the object for immutability
    question.selectAnswer = answer;
  }

}
