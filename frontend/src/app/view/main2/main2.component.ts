import { Component, OnInit } from '@angular/core';
import {ParentService} from "../../service/parent.service";

@Component({
  selector: 'app-main2',
  templateUrl: './main2.component.html',
  styleUrls: ['./main2.component.css']
})
export class Main2Component implements OnInit {

  scrl:boolean=false;
  profileName:string="No teacher";
  profileDiscription:string="empty discription"

  constructor(private parentService:ParentService ) { }

  ngOnInit() {
  }

  logout(){
    this.parentService.logout();
  }

}
