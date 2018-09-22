import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Router} from "@angular/router";
import {NgForm} from "@angular/forms";
import {Teacher} from "../../../dto/teacher";
import {AuthService} from "../../../service/auth.service";
import {Profileimg} from "../../../dto/profileimg";


@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css']
})
export class SettingsComponent implements OnInit {






  rescode: string;
  file: File;
  @ViewChild("frmTeacher") frmCustomers: NgForm;
  teacher: Teacher = new Teacher();

  constructor(private elem:ElementRef,  private teacherService: AuthService, private router: Router) {
  }

  ngOnInit() {

    this.teacherService.searchTeacher(sessionStorage.getItem("scode")).subscribe(
      ((result) => {
        this.teacher = result;

      })
    )
  }

  SignUpTeacher() {


    let booleanObservable = this.teacherService.saveTeacher(this.teacher).subscribe(
      (result) => {
        if (result) {
          swal("Data Updated");

        } else {
          swal({
            title: "Try again",


          });
        }
      }
    );
  }






}
