import {Component, OnInit} from '@angular/core';
import {Student} from "../../../dto/student";
import {Team} from "../../../dto/team";
import {Teacher} from "../../../dto/teacher";
import {TeamService} from "../../../service/team.service";
import {AuthService} from "../../../service/auth.service";
import {StudentService} from "../../../service/student.service";
import {SweetAlertService} from "angular-sweetalert-service";
import {NgxAlertsService} from "ngx-alerts/lib/ngx-alerts.service";


@Component({
  selector: 'app-updatestudent',
  templateUrl: './updatestudent.component.html',
  styleUrls: ['./updatestudent.component.css']
})
export class UpdatestudentComponent implements OnInit {

  searcStudentss: string;

  newStudet: Student = new Student();


  tempTeam: Student = null;
  manuallySelected: boolean = false;
  selectStudent: Student = new Student();
  teacher: Teacher = new Teacher();
  students: Array<Student> = [];

  savedmsg: boolean = false;

  constructor(private teamService: TeamService, private authService: AuthService, private studentService: StudentService) {
  }

  ngOnInit() {

    this.authService.searchTeacher(sessionStorage.getItem("scode")).subscribe(
      ((result) => {
        this.teacher = result;

      })
    )
    this.loadAllStudent(sessionStorage.getItem("scode"));

    this.selectStudent.teamid = this.studentService.getSearchTeam().teamid;


  }


  closeAlert() {
    this.savedmsg = false;
  }

  saveStudent(): void {

    this.studentService.saveStudent(this.selectStudent).subscribe(
      ((result) => {
        alert("saves");
      })
    )

  }

  selectStudents(student: Student): void {

    this.selectStudent = student;
    this.tempTeam = Object.assign({}, student);
    this.manuallySelected = true;
  }

  loadAllStudent(username: string): void {
    this.studentService.getAllStudents2(username).subscribe(
      (result) => {
        this.students = result;
      }
    )
  }


  searchStudent() {
    this.studentService.searchStudent(this.searcStudentss).subscribe(
      ((result) => {

        this.selectStudent = result;
      })
    )
  }


  sendStudentName(){

    this.studentService.setStudentName(this.selectStudent.studentname);

  }

  deleteStudent(student: Student): void {

    this.studentService.deleteStudent(student.studentname).subscribe(
      ((result)=>{
        alert("Student Deleted");
        this.loadAllStudent(sessionStorage.getItem("scode"));
      })
    )




  }
}
