import {Component, OnInit, ViewChild} from '@angular/core';
import {AuthService} from "../../../service/auth.service";
import {Teacher} from "../../../dto/teacher";
import {NgForm} from "@angular/forms";
import {b, rS} from "@angular/core/src/render3";
import {Router} from "@angular/router";
import {MainComponent} from "../../main/main.component";


@Component({
  selector: 'app-tsignup',
  templateUrl: './tsignup.component.html',
  styleUrls: ['./tsignup.component.css']
})
export class TsignupComponent implements OnInit {


  @ViewChild("frmTeacher") frmCustomers: NgForm;
  teacher: Teacher = new Teacher();


  constructor(private teacherService: AuthService, private router: Router ) {
  }

  ngOnInit() {
  }

  SignUpTeacher() {
    let booleanObservable = this.teacherService.saveTeacher(this.teacher).subscribe(
      (result) => {
        if (result) {

          this.router.navigate(['/home/teacher/tsignin']);
        }
      }
    );
  }

}
