import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserRevRest } from '../components/beans/UserRevRest';
import { ActivatedRoute } from '@angular/router';
import { ControlPanelService } from '../service/control-panel.service';
import { User } from '../components/beans/User';

@Component({
  selector: 'app-some-profile',
  templateUrl: './some-profile.component.html',
  styleUrls: ['./some-profile.component.css']
})
export class SomeProfileComponent implements OnInit {

  reviews: Array<UserRevRest>;
  id: number
  username: String;

  constructor(private router: Router, private activatedRouter: ActivatedRoute,
  private cpService : ControlPanelService) { }

  ngOnInit() {
    // this.sub = this.activatedRouter.params.subscribe(params => {
    //   this.id = +params['id'];
    // });

    this.id = +this.activatedRouter.snapshot.params['userId'];
    this.username = this.activatedRouter.snapshot.params['username'];

    console.log(this.username);
    this.getReview();
  }

  getReview() {
    this.cpService.getReviewByUserId(this.id, this.username).subscribe(data => {
      console.log(sessionStorage.getItem('someUserReviews'));
      this.reviews = JSON.parse(sessionStorage.getItem('someUserReviews'));
      this.reviews.sort(function (obj1, obj2) {
        // Ascending: first age less than the previous
        return obj2.review_id - obj1.review_id;
      });
    })
  }

  goToRest(id: number) {
    this.router.navigate(['/add', id]);
  }


  // goToRest(id: number) {
  //   this.router.navigate(['/add', id]);
  // }

}
