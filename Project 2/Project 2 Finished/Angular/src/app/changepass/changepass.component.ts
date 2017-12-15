import { Component, OnInit } from '@angular/core';
import { User } from '../components/beans/User';
import { AlertService } from '../service/alert.service';
import { ControlPanelService } from '../service/control-panel.service';

@Component({
  selector: 'app-changepass',
  templateUrl: './changepass.component.html',
  styleUrls: ['./changepass.component.css']
})
export class ChangepassComponent implements OnInit {

  user: User;
  matched: boolean;
  newpassword: string;
  confpassword: string;

  constructor(private alert: AlertService, private cpService: ControlPanelService) { }


  ngOnInit() {
    this.user = JSON.parse(sessionStorage.getItem('currentUser'));
    this.matched = false;
  }

  updatePass() {

    if (this.newpassword === this.confpassword) {
      this.user = JSON.parse(sessionStorage.getItem('currentUser'));
      this.user.password = this.newpassword;
      this.cpService.updatePass(this.user)
        .subscribe(data => {
          this.alert.success('Password Updated', true);
        },
        error => {
          this.alert.error('Failed to change Password')
        }
        );
    }
    else {
      return this.alert.error('Password Mismatched');
    }
  }
}
