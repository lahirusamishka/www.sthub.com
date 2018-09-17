import { Component, OnInit } from '@angular/core';
import {Team} from "../../../dto/team";
import {TeamService} from "../../../service/team.service";
import {AuthService} from "../../../service/auth.service";
import {Teacher} from "../../../dto/teacher";

@Component({
  selector: 'app-student-manage',
  templateUrl: './student-manage.component.html',
  styleUrls: ['./student-manage.component.css']
})
export class StudentManageComponent implements OnInit {


  selectedTeam: Team = new Team();
  teacher: Teacher = new Teacher();
  teams: Array<Team> = [];

  constructor( private teamService: TeamService,private authService: AuthService) { }

  ngOnInit() {
    this.authService.searchTeacher(sessionStorage.getItem("scode")).subscribe(
      ((result) => {
        this.teacher = result;
        this.selectedTeam.teacherUserName = result.name;
      })
    )
    this.loadAllTeams(sessionStorage.getItem("scode"));

  }


  getTeam(){


    alert(this.teams)


  }



  loadAllTeams(username: string): void {
    this.teamService.getAllTeam(username).subscribe(
      (result) => {
        this.teams = result;
      }
    )
  }

}
