import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';
import { ControlPanelService } from './control-panel.service';
import { Router } from '@angular/router';

@Injectable()
export class UserResolve implements Resolve<any> {
  
  constructor(private cpService: ControlPanelService) {}
  
  resolve(route: ActivatedRouteSnapshot) {
    return this.cpService.getReviewByUser();
  }
}