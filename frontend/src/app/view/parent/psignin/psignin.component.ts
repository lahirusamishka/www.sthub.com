import { Component, OnInit } from '@angular/core';
import {Parent} from "../../../dto/parent";
import {ParentService} from "../../../service/parent.service";
import {User} from "../../../dto/user";

@Component({
  selector: 'app-psignin',
  templateUrl: './psignin.component.html',
  styleUrls: ['./psignin.component.css']
})
export class PsigninComponent implements OnInit {

  user: User = new User();
  failed: boolean;
  validatermassage:string;


  constructor(private parentService: ParentService) { }

  ngOnInit() {
  }
  login(): void{
    this.parentService.login(this.user).subscribe(
      (result)=>{

        this.failed = !result;
      }
    );
  }

}
