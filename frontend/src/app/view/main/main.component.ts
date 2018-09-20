import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../service/auth.service";
import {Teacher} from "../../dto/teacher";
import {map} from "rxjs/operators";
import {TeamService} from "../../service/team.service";
import {Team} from "../../dto/team";
import {isNumber} from "util";
import {StudentService} from "../../service/student.service";

export const profiles = "";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  profiledetails: string;
  teams: Array<Team> = [];
  numbers:Array<number>=[];

  teacher: Teacher = new Teacher();

  selectedTeam: Team = new Team();

  constructor(private authservice: AuthService, private teamService: TeamService,private studentService:StudentService) {
  }

  ngOnInit() {

    this.authservice.searchTeacher(sessionStorage.getItem("scode")).subscribe(
      ((result) => {
        this.teacher = result;
      })
    )
    this.loadAllTeams(sessionStorage.getItem("scode"));
    this.loadAllTeamMembers();

  }

  private loadAllTeamMembers() {
  }

  loadAllTeams(username: string): void {
    this.teamService.getAllTeam(username).subscribe(
      (result) => {

        this.teams = result;
       /* this.teams.forEach((item, index) => {
          console.log(item);

        });*/




      }
    )
  }

  selectTeam(tems: Team) {

    this.selectedTeam.teamid=tems.teamid;


    sessionStorage.setItem("scodes","d");

  }

  logout() {
    this.authservice.logout();
  }



}
