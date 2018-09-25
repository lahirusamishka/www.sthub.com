import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../../service/auth.service";
import {Teacher} from "../../../dto/teacher";
import {Team} from "../../../dto/team";
import {TeamService} from "../../../service/team.service";
import {StudentService} from "../../../service/student.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  searchbar:string;
  backbutton:boolean;
  seaechNumber: number;
  test: boolean;

  teacher: Teacher = new Teacher();
  selectedTeam: Team = new Team();
  tempTeam: Team = null;
  manuallySelected: boolean = false;
  teams: Array<Team> = [];

  constructor(private authService: AuthService,
              private teamService: TeamService,
              private studentService:StudentService,
              private router:Router) {
  }

  ngOnInit() {

    this.authService.searchTeacher(sessionStorage.getItem("scode")).subscribe(
      ((result) => {
        this.teacher = result;
        this.selectedTeam.teacherUserName = result.name;
      })
    )
    this.loadAllTeams(sessionStorage.getItem("scode"));
  }


  searchTeam() {



    this.teamService.searchTeam(this.seaechNumber).subscribe(
      (result)=>{

        this.selectedTeam=result;
        this.studentService.setSearchTeam(this.selectedTeam);
      }
    )

  }

  saveTeam(): void {

    this.teamService.saveTeam(this.selectedTeam).subscribe(
      (result) => {
        this.test = result;
        if (result) {
          swal("Team saved successfully" );

          this.loadAllTeams(sessionStorage.getItem("scode"));
        } else {
          swal("Failed to save the Team");
        }
      }
    )
    // print test
  }

  claerform(){

    this.backbutton=false;

    this.router.navigate(['/main/dashboard']);
  }


  loadAllTeams(username: string): void {
    this.teamService.getAllTeam(username).subscribe(
      (result) => {
        this.teams = result;
      }
    )
  }

  selectTeam(team: Team): void {
    // this.clear();
  /*  this.searchTeam();*/

    this.studentService.setSearchTeam(this.selectedTeam);
    this.selectedTeam = team;
    this.tempTeam = Object.assign({}, team);
    this.manuallySelected = true;
  }

  logout() {
    this.authService.logout();
  }


  deleteTeam(team: Team): void {
    if (confirm("Are you sure you want to delete this Team?")) {
      this.teamService.deleteTeam(team.teamid).subscribe(
        (result) => {
          if (result) {
            swal("Team has been deleted successfully");
          } else {
            swal("Failed to delete the Team");
          }
          this.loadAllTeams(sessionStorage.getItem("scode"));

        }
      )
    }
  }


}
