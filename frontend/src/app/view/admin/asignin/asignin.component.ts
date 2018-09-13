import { Component, OnInit } from '@angular/core';
import {Parent} from "../../../dto/parent";
import {ParentService} from "../../../service/parent.service";
import {AdminService} from "../../../service/admin.service";
import {Admin} from "../../../dto/admin";

@Component({
  selector: 'app-asignin',
  templateUrl: './asignin.component.html',
  styleUrls: ['./asignin.component.css']
})
export class AsigninComponent implements OnInit {

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
