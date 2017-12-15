import { Component, OnInit } from '@angular/core';
import { User } from '../components/beans/User';
import { ControlPanelService } from '../service/control-panel.service';
import { Review } from '../components/beans/Review';
import { UserRevRest } from '../components/beans/UserRevRest';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ireviewed',
  templateUrl: './ireviewed.component.html',
  styleUrls: ['./ireviewed.component.css']
})
export class IreviewedComponent implements OnInit {

  user: User;
  reviews: Array<UserRevRest>;
  // allReviews: Array<Review>;

  constructor(private cpService: ControlPanelService,
    private router: Router) { }

  ngOnInit() {
    this.user = JSON.parse(sessionStorage.getItem('currentUser'));
    this.getReview();

  }

  getReview() {
    this.cpService.getReviewByUser().subscribe(data => {
      this.reviews = JSON.parse(sessionStorage.getItem('userReviews'));
      this.reviews.sort(function (obj1, obj2) {
        // Ascending: first age less than the previous
        return obj2.review_id - obj1.review_id;
      });
    })
  }

  goToRest(id: number) {
    this.router.navigate(['/add', id]);
  }


}
