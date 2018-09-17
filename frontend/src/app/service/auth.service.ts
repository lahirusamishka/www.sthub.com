import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Observable} from "rxjs";
import {User} from "../dto/user";
import {map} from "rxjs/operators";
import {Teacher} from "../dto/teacher";

export const MAIN_URL= "http://localhost:8080";
const URL = '/api/v1/teachers';
const URL2= '/api/v1/teachers/login'

@Injectable()
export class AuthService {


  username:string;


  constructor(private http: HttpClient, private router: Router) {

  }

  login(user: User): Observable<boolean> {
    return this.http.post<boolean>(MAIN_URL + URL2, user)
      .pipe(
        map((result)=>{
          sessionStorage.setItem("token", result + "");
          if (result){

            this.router.navigate(['/main']);
          }
          return result;
        })
      )
  }

  saveTeacher(teacher: Teacher): Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL + URL,teacher);
  }


  searchTeacher(username :String): Observable<Teacher>{
    return this.http.get<Teacher>(MAIN_URL + URL + "/"+username);
  }

  static isAuthenticated(): boolean{
    if (sessionStorage.getItem("token")){
      return sessionStorage.getItem("token") != 'false';
    }
  }

  logout(): void{
    sessionStorage.removeItem("token");
    this.router.navigate(['/home/teacher/tsignin']);
  }


}
