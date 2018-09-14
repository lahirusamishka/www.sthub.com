import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Team} from "../dto/team";

export const MAIN_URL = "http://localhost:8080";
const URL = "/api/v1/teams";

@Injectable()
export class TeamService {

  constructor(private http: HttpClient) {
  }

  getAllTeam(username: String): Observable<Array<Team>> {
    return this.http.get<Array<Team>>(MAIN_URL + URL + "/all/" + username);
  }

  deleteTeam(id: number): Observable<boolean> {
       return this.http.delete<boolean>(MAIN_URL + URL + "/" + id);
  }

  saveTeam(team: Team): Observable<boolean> {

    return this.http.post<boolean>(MAIN_URL + URL, team);
  }

  getTotalTeam(): Observable<number> {
    return this.http.get<number>(MAIN_URL + URL + "/count");
  }

  searchTeam(id: number): Observable<Team> {
    return this.http.get<Team>(MAIN_URL + URL + "/" + id);
  }

}
