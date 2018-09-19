import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";


import {MAIN_URL} from "./auth.service";
import {Parent} from "../dto/parent";
import {User} from "../dto/user";
import {Teacher} from "../dto/teacher";
import {Student} from "../dto/student";

const URL = '/api/v1/parents';
const URL2= '/api/v1/parents/login'
@Injectable()
export class ParentService {



  constructor(private http: HttpClient, private router: Router) {

  }

  login(user: User): Observable<boolean> {
    return this.http.post<boolean>(MAIN_URL + URL2, user)
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

  saveParent(parent: Parent): Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL + URL,parent);
  }

  getAllParents(): Observable<Array<Parent>> {
    return this.http.get<Array<Parent>>(MAIN_URL + URL);
  }

  deleteParent(parentNme: string): Observable<boolean> {
    return this.http.delete<boolean>(MAIN_URL + URL + "/" + parentNme);
  }

  searchTeacher(username :String): Observable<Parent>{
    return this.http.get<Parent>(MAIN_URL + URL + "/"+username);
  }

  getTotalTeachers(): Observable<number>{
    return this.http.get<number>(MAIN_URL + URL + "/count");
  }

  static isAuthenticated(): boolean{
    if (sessionStorage.getItem("token")){
      return sessionStorage.getItem("token") != 'false';
    }
  }

  logout(): void{
    sessionStorage.removeItem("token");
    this.router.navigate(['/loginpage/parent/psignin']);
  }

}
