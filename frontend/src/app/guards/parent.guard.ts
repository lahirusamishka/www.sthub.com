import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import { Observable } from 'rxjs';
import {AuthService} from "../service/auth.service";
import {ParentService} from "../service/parent.service";

@Injectable()
export class ParentGuard implements CanActivate {

  constructor(private authService: ParentService,private router:Router){

  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {

    if (!ParentService.isAuthenticated()){
      this.router.navigate(['/home']);
      return false;
    }

    return true;

  }
}
