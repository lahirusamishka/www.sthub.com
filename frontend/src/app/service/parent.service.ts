import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";


import {MAIN_URL} from "./auth.service";
import {Parent} from "../dto/parent";

const URL = '/api/v1/parentlogin';
@Injectable()
export class ParentService {



  constructor(private http: HttpClient, private router: Router) {

  }

  login(parent: Parent): Observable<boolean> {
    return this.http.post<boolean>(MAIN_URL + URL, parent)
      .pipe(
        map((result)=>{
          sessionStorage.setItem("token", result + "");
          if (result){

            this.router.navigate(['/main2']);
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
