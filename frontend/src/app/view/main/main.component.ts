import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../service/auth.service";
import {Teacher} from "../../dto/teacher";
import {map} from "rxjs/operators";
import {TeamService} from "../../service/team.service";
import {Team} from "../../dto/team";

export const profiles = "";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  profiledetails: string;
  teams: Array<Team> = [];
  teacher: Teacher = new Teacher();


  constructor(private authservice: AuthService,private teamService:TeamService) {
  }

  ngOnInit() {

    this.authservice.searchTeacher(sessionStorage.getItem("scode")).subscribe(
      ((result)=>{
        this.teacher=result;
      })
    )
    this.loadAllTeams(sessionStorage.getItem("scode"));

  }

  loadAllTeams(username: string): void {
    this.teamService.getAllTeam(username).subscribe(
      (result) => {
        this.teams = result;
      }
    )
  }

  logout() {
    this.authservice.logout();
  }


}
