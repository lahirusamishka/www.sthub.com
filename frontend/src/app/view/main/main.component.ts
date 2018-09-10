import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../service/auth.service";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {


  profileName:string="No teacher";
  profileDiscription:string="empty discription"


  constructor(private authservice:AuthService) { }

  ngOnInit() {
  }


  logout(){
    this.authservice.logout();
  }

}
