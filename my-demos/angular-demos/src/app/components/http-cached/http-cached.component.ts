import { Component, OnInit, OnDestroy, Inject } from '@angular/core';
import {FlashcardService} from '../../services/flashcard.service';
import { Subscription } from 'rxjs/Rx';

@Component({
  selector: 'app-http-cached',
  templateUrl: './http-cached.component.html'
})
export class HttpCachedComponent implements OnInit, OnDestroy {
  // not done yet
  public flashcards;
  public flashcardsObserver: Subscription;
  public filterCompleted = false;

  constructor(private flashCardService: FlashcardService) {

  }

  ngOnInit() {
    this.getData();
  }

  getData() {
    this.flashcardsObserver = this.flashCardService.data$.subscribe(
      requestData => {
        console.log(requestData);
        this.flashcards = requestData;
      },
      error => console.log(error)
    );

  }

  public toggleCompleted() {
    this.filterCompleted = !this.filterCompleted;
  }

  ngOnDestroy() {
    this.flashcardsObserver.unsubscribe();
  }
}
