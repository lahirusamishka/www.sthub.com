import { Component, OnInit } from '@angular/core';
import {Admin} from "../../dto/admin";
import {AdminService} from "../../service/admin.service";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  admin:Admin = new Admin();
  failed: boolean;

  inValidLogin:boolean;

  constructor(private adminService: AdminService) { }

  ngOnInit() {
  }
  login(): void{
    this.adminService.login(this.admin).subscribe(
      (result)=>{

        this.failed = !result;
      }
    );
  }
}
