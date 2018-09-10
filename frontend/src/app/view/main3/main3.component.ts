import { Component, OnInit } from '@angular/core';
import {AdminService} from "../../service/admin.service";

@Component({
  selector: 'app-main3',
  templateUrl: './main3.component.html',
  styleUrls: ['./main3.component.css']
})
export class Main3Component implements OnInit {

  constructor(private adminService:AdminService) { }

  ngOnInit() {
  }

  logout(){
    this.adminService.logout();
  }

}
