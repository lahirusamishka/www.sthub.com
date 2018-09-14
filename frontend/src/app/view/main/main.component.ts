import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../service/auth.service";
import {Teacher} from "../../dto/teacher";
import {map} from "rxjs/operators";

export const profiles = "";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  profiledetails: string;

  teacher: Teacher = new Teacher();


  constructor(private authservice: AuthService) {
  }

  ngOnInit() {

    this.authservice.searchTeacher(sessionStorage.getItem("scode")).subscribe(
      ((result)=>{
        this.teacher=result;
      })
    )
    

  }



  logout() {
    this.authservice.logout();
  }


}
