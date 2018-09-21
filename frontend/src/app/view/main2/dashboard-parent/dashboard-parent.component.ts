import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {Teacher} from "../../../dto/teacher";
import {AuthService} from "../../../service/auth.service";
import {Router} from "@angular/router";
import {ParentService} from "../../../service/parent.service";
import {Parent} from "../../../dto/parent";

@Component({
  selector: 'app-dashboard-parent',
  templateUrl: './dashboard-parent.component.html',
  styleUrls: ['./dashboard-parent.component.css']
})
export class DashboardParentComponent implements OnInit {

  rescode:string;

  @ViewChild("frmTeacher") frmCustomers: NgForm;
  parent: Parent = new Parent();

  constructor(private parenetService: ParentService, private router: Router ) {
  }

  ngOnInit() {

    this.parenetService.searchParent(sessionStorage.getItem("scode")).subscribe(
      ((result) => {
        this.parent = result;

      })
    )
  }

  SignUpTeacher() {



    let booleanObservable = this.parenetService.saveParent(this.parent).subscribe(
      (result) => {
        if (result) {
          swal({
            title: "Good job!",
            icon: "success"

          });
          this.router.navigate(['/loginpage/teacher/tsignin']);
        }else {
          swal({
            title: "Try again",
            icon: "warning",

          });
        }
      }
    );
  }
}
