import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router, ActivatedRoute} from '@angular/router';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class AuthGuard implements CanActivate {

  constructor(private router: Router) {}

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot):  boolean {

    if (localStorage.getItem('userToken') != null) {
      return true;
    }
      this.router.navigate(['/login']);
      return false;
  }
}
/*
@Injectable()
export class AuthGuardLogin implements CanActivate {

  constructor(private router: Router) {}

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot):  boolean {

    if (localStorage.getItem('userToken') != null) {
      this.router.navigate(['/home']);
      return true;
    } else {

      this.router.navigate(['/login']);
      return false;
    }
 //   return false;
  }
}*/
