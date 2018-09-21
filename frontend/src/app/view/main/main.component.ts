import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../service/auth.service";
import {Teacher} from "../../dto/teacher";
import {map} from "rxjs/operators";
import {TeamService} from "../../service/team.service";
import {Team} from "../../dto/team";
import {isNumber} from "util";
import {StudentService} from "../../service/student.service";
import {Teammember} from "../../dto/teammember";

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

  teammembers:Array<Teammember>=[];

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


  }



  loadAllTeams(username: string): void {
    this.teamService.getAllTeamMembers(username).subscribe(
      ((result)=>{
        this.teammembers=result;
      })
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
