import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../../service/auth.service";
import {Teacher} from "../../../dto/teacher";
import {Team} from "../../../dto/team";
import {TeamService} from "../../../service/team.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  teacher: Teacher = new Teacher();
  selectedTeam: Team = new Team();
  tempTeam: Team = null;
  manuallySelected: boolean = false;
  teams: Array<Team> = [];

  constructor(private authService: AuthService, private teamService: TeamService) {
  }

  ngOnInit() {

    this.authService.searchTeacher(sessionStorage.getItem("scode")).subscribe(
      ((result) => {
        this.teacher = result;
      })
    )
    this.loadAllTeams(sessionStorage.getItem("scode"));
  }

  saveTeam():void{
    this.teamService.saveTeam(this.selectedTeam).subscribe(
      (result)=>{
        if (result){
          alert("saved successfully");
          this.loadAllTeams(sessionStorage.getItem("scode"));
        }else{
          alert("Failed to save");
        }
      }
    )
  }

  loadAllTeams(username:string): void {
    this.teamService.getAllTeam(username).subscribe(
      (result) => {
        this.teams = result;
      }
    )
  }

  selectTeam(team: Team): void {
    // this.clear();
    this.selectedTeam = team;
    this.tempTeam = Object.assign({}, team);
    this.manuallySelected = true;
  }

  logout() {
    this.authService.logout();
  }


  deleteTeam(team: Team): void {
    if (confirm("Are you sure you want to delete this customer?")) {
      this.teamService.deleteTeam(team.teamid).subscribe(
        (result) => {
          if (result) {
            alert("Customer has been deleted successfully");
          } else {
            alert("Failed to delete the customer");
          }
          this.loadAllTeams(sessionStorage.getItem("scode"));
        }
      )
    }
  }


}
