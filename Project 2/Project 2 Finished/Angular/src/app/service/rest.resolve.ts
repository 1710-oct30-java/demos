import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';
import { RestService } from './rest-service.service';

@Injectable()
export class RestResolve implements Resolve<any> {
  
  constructor(private restService: RestService) {}
  
  resolve(route: ActivatedRouteSnapshot) {
    return this.restService.getRestaurantById(route.params['id']);
  }
}