import { Component, OnInit } from '@angular/core';
import {Team} from "../../../dto/team";
import {TeamService} from "../../../service/team.service";
import {AuthService} from "../../../service/auth.service";
import {Teacher} from "../../../dto/teacher";
import {StudentService} from "../../../service/student.service";
import {Student} from "../../../dto/student";

@Component({
  selector: 'app-student-manage',
  templateUrl: './student-manage.component.html',
  styleUrls: ['./student-manage.component.css']
})
export class StudentManageComponent implements OnInit {

  student:Student = new Student();

  selectedTeam: Team = new Team();
  teacher: Teacher = new Teacher();
  teams: Array<Team> = [];

  savedmsg:boolean=false;


  constructor( private teamService: TeamService,private authService: AuthService,private studentService:StudentService) { }

  ngOnInit() {
    this.authService.searchTeacher(sessionStorage.getItem("scode")).subscribe(
      ((result) => {
        this.teacher = result;
        this.selectedTeam.teacherUserName = result.name;
      })
    )
    this.loadAllTeams(sessionStorage.getItem("scode"));

    this.selectedTeam.teamid=this.studentService.getSearchTeam().teamid;

  }


  closeAlert(){
    this.savedmsg=false;
  }

  saveStudent():void{


    this.student.teamid=this.selectedTeam.teamid;
    this.student.teachername=this.teacher.name;
    this.studentService.saveStudent(this.student).subscribe(
      ((result)=>{
        this.savedmsg=result;
      })
    )

  }



  loadAllTeams(username: string): void {
    this.teamService.getAllTeam(username).subscribe(
      (result) => {
        this.teams = result;
      }
    )
  }

}
