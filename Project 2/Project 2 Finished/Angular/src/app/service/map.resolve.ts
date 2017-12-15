import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';
import { RestService } from './rest-service.service';
import { MapService } from './map.service';

@Injectable()
export class MapResolve implements Resolve<any> {
  
  constructor(private mapService: MapService) {}
  
  resolve(route: ActivatedRouteSnapshot) {
    return this.mapService.getRestMarkers();
  }
}