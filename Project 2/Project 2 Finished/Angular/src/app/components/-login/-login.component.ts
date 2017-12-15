import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../service/auth.service';
import { Cred } from '../beans/Cred';
import { Router } from '@angular/router';
import { User } from '../beans/User';
import { ActivatedRoute } from '@angular/router';
import { AlertService } from '../../service/alert.service';
import { RestService } from '../../service/rest-service.service';
@Component({
    selector: 'app--login',
    templateUrl: './-login.component.html',
    styleUrls: ['./-login.component.css']
})

export class LoginComponent implements OnInit {
    model: User;
    loading = false;
    returnUrl: string;

    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthService,
        private alertService: AlertService,
        private restService: RestService) { }

    ngOnInit() {
        // reset login status
        this.authenticationService.logout();
        this.model = new User();
        sessionStorage.clear();
        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

    login() {
        this.loading = true;
        this.authenticationService.login(this.model)
            .subscribe(
            data => {
                this.getRestaurants();
                    this.router.navigate([this.returnUrl]);

            },
            error => {
                this.alertService.error(error);
                this.loading = false;
            });
    }

    getRestaurants()
    {
        this.restService.getAllRestaurant().subscribe(resp => {console.log('got all rest')},
        err => {console.log('failed to get rest')})
    }
}