import {Injectable} from '@angular/core';
import {MAIN_URL} from "./auth.service";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Student} from "../dto/student";
import {Team} from "../dto/team";

const URL = '/api/v1/students';

@Injectable()
export class StudentService {

  team:Team = new Team();

  constructor(private http: HttpClient) {
  }

  getAllstudent(): Observable<Array<Student>> {
    return this.http.get<Array<Student>>(MAIN_URL + URL);
  }

  getAllStudents(teamid: Team): Observable<Array<Student>> {
    return this.http.get<Array<Student>>(MAIN_URL + URL + "/" + teamid);
  }


  setSearchTeam(team:Team){
    this.team=team;

  }
  getSearchTeam(){
    return this.team;
  }
  deleteStudent(studentName: string): Observable<boolean> {
    return this.http.delete<boolean>(MAIN_URL + URL + "/" + studentName);
  }

  saveStudent(student: Student): Observable<boolean> {

    return this.http.post<boolean>(MAIN_URL + URL, student);
  }

  getTotalStudent(): Observable<number> {
    return this.http.get<number>(MAIN_URL + URL + "/count");
  }

  searchCustomer(studentName: String): Observable<Student> {
    return this.http.get<Student>(MAIN_URL + URL + "/" + studentName);
  }
}
