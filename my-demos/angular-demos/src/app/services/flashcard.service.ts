import { Injectable, Inject } from '@angular/core';
import { Http, Response } from '@angular/http';
import { BehaviorSubject } from 'rxjs/Rx';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class FlashcardService {

  private dataSubject = new BehaviorSubject([]);
  data$: Observable<any> = this.dataSubject.asObservable();

  public flashcards;
  private prom;

  constructor(@Inject(Http) public http: Http) {
    this.fetch();
  }

  getFlashcards() {
    return this.flashcards;
  }

  fetch(): void {
    this.flashcards = this.http.get('http://localhost:8080/ajax/flashcards').map(
      resp => resp.json(),
      err => console.log(err)
    )
    .subscribe(
      resp => {
        this.dataSubject.next(resp);
      },
      err => {
        console.log('error occurred loading flashcards' + err);
      }
    );
  }

}
