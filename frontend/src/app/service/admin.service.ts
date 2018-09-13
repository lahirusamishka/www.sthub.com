import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Parent} from "../dto/parent";
import {Observable} from "rxjs";
import {MAIN_URL} from "./auth.service";
import {map} from "rxjs/operators";
import {Admin} from "../dto/admin";

const URL = '/api/v1/adminlogin';

@Injectable()
export class AdminService {

  constructor(private http: HttpClient, private router: Router) {

  }

  login(admin: Admin): Observable<boolean> {
    return this.http.post<boolean>(MAIN_URL + URL, admin)
      .pipe(
        map((result)=>{
          sessionStorage.setItem("token", result + "");
          if (result){

            this.router.navigate(['/main3']);
          }

          return result;
        })
      )
  }

  static isAuthenticated(): boolean{
    if (sessionStorage.getItem("token")){
      return sessionStorage.getItem("token") != 'false';
    }
  }

  logout(): void{
    sessionStorage.removeItem("token");
    this.router.navigate(['/home']);
  }
}
