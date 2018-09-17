import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {Parent} from "../../../dto/parent";
import swal from "sweetalert";
import {AuthService} from "../../../service/auth.service";
import {Router} from "@angular/router";
import {ParentService} from "../../../service/parent.service";

@Component({
  selector: 'app-psignup',
  templateUrl: './psignup.component.html',
  styleUrls: ['./psignup.component.css']
})
export class PsignupComponent implements OnInit {


  rescode:string;
  @ViewChild("frmTeacher") frmCustomers: NgForm;

  parent:Parent = new Parent();

  constructor(private parentservice: ParentService, private router: Router) { }

  ngOnInit() {
  }

  SignUpParent() {


    let booleanObservable = this.parentservice.saveParent(this.parent).subscribe(
      (result) => {
        if (result) {
          swal({
            title: "Good job!",
            icon: "success"

          });
          this.router.navigate(['/loginpage/parent/psignin']);
        } else {
          swal({
            title: "Try again",
            icon: "warning",

          });
        }
      }
    );
  }
}
