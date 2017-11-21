import {Injector, Injectable} from '@angular/core';
import {UIRouter} from '@uirouter/angular';

/** UIRouter Config  */
export function uiRouterConfigFn(router: UIRouter) {

  // If no URL matches, go to the `hello` state by default
  router.urlService.rules.otherwise({ state: 'login' });

  // Use ui-router-visualizer to show the states as a tree
  // and transitions as a timeline
  // visualizer(router);
}
