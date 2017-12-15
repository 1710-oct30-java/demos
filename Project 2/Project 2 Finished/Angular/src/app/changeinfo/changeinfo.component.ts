import { Component, OnInit } from '@angular/core';
import { User } from '../components/beans/User';
import { ControlPanelService } from '../service/control-panel.service';
import { AlertService } from '../service/alert.service';

@Component({
  selector: 'app-changeinfo',
  templateUrl: './changeinfo.component.html',
  styleUrls: ['./changeinfo.component.css']
})
export class ChangeinfoComponent implements OnInit {

  user: User;
  constructor(private cpService: ControlPanelService,
    private alert: AlertService) { }

  ngOnInit() {
    this.user = JSON.parse(sessionStorage.getItem('currentUser'));
  }


  updateInfo() {
    this.cpService.updateInfo(this.user)
      .subscribe(data => {
        this.alert.success('Info Updated', true);
      },
      error => {
        this.alert.error('Failed to change Info')
      }
      );
  }
}

