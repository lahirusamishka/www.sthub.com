import {Component, OnInit} from '@angular/core';
import {AdminService} from "../../service/admin.service";
import {ParentService} from "../../service/parent.service";
import {TeamService} from "../../service/team.service";
import {AuthService} from "../../service/auth.service";
import {StudentService} from "../../service/student.service";

@Component({
  selector: 'app-main3',
  templateUrl: './main3.component.html',
  styleUrls: ['./main3.component.css']
})
export class Main3Component implements OnInit {

  parentCont = 0;
  teamCont = 0;
  teacherCount = 0;
  studentCount = 0;

  constructor(private adminService: AdminService, private  parentService: ParentService, private teamservice: TeamService, private teacherSerivice: AuthService, private studentService: StudentService) {
  }

  ngOnInit() {

    this.parentService.getTotalTeachers().subscribe(
      ((result) => {
        this.parentCont = result;
      })
    )
    this.teamservice.getTotalTeam().subscribe(
      ((result) => {
        this.teamCont = result;
      })
    )
    this.teacherSerivice.getTotalTeachers().subscribe(
      ((result) => {
        this.teacherCount = result;
      })
    )

    this.teacherSerivice.getTotalTeachers().subscribe(
      ((result) => {
        this.studentCount = result;
      })
    )

  }

  logout() {
    this.adminService.logout();
  }


}
