import {Injectable} from '@angular/core';
import {MAIN_URL} from "./auth.service";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Student} from "../dto/student";
import {Team} from "../dto/team";
import {Teacher} from "../dto/teacher";

const URL = '/api/v1/students';

@Injectable()
export class StudentService {


  team:Team = new Team();
  studentName:string;
  teamIds:number;

  constructor(private http: HttpClient) {
  }

  getAllStduentByTeamId(teamId:number):Observable<Array<Student>>{

    return this.http.get<Array<Student>>(MAIN_URL+URL+"/filter/"+teamId);
  }


  getAllstudent(): Observable<Array<Student>> {
    return this.http.get<Array<Student>>(MAIN_URL + URL);
  }

  getAllStudents(teamid: Team): Observable<Array<Student>> {
    return this.http.get<Array<Student>>(MAIN_URL + URL + "/" + teamid);
  }


  getAllStudents2(teachername: String): Observable<Array<Student>> {
    return this.http.get<Array<Student>>(MAIN_URL + URL + "/student2/" + teachername);
  }

  setTeamIds(teamno:number){
    this.teamIds=teamno;
  }


  getTeamIds(){
    return  this.teamIds;
  }
  setSearchTeam(team:Team){
    this.team=team;

  }
  getStudentName(){
    return this.studentName;
  }

  setStudentName(studentName:string){
    this.studentName=studentName;
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

  searchStudent(studentName: String): Observable<Student> {
    return this.http.get<Student>(MAIN_URL + URL + "/" + studentName);
  }

}
