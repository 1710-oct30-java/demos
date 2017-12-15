import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../service/auth.service';
import { User } from '../beans/User';
import { Roles } from '../beans/Roles';
import { Router } from '@angular/router';
import { AlertService } from '../../service/alert.service';

@Component({
    moduleId: module.id.toString(),
    templateUrl: './-reg.component.html',
    styleUrls: ['./-reg.component.css']
})
export class RegComponent implements OnInit {

    model: User;
    // messages: Message[] = [];
    loading = false;

    // roleNum: number;
    // roles: Array<Object> = [
    //     { num: 1, name: 'DINER' },
    //     { num: 2, name: 'OWNER' }
    // ];


    constructor(private authService: AuthService,
        private router: Router,
    private alertService : AlertService) {

    }

    ngOnInit(): void {
        this.model = new User();
        this.model.roleId = 1;
    }

    register() {
        this.loading = true;
        this.authService.register(this.model)
            .subscribe(
                data => {
                    this.alertService.success('Registration successful', true);
                    this.router.navigate(['/login']);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
    // toNumber() {
    //     this.roleNum = +this.roleNum;
    //     console.log(this.roleNum);
    // }
}
