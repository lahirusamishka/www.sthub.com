import { Component, OnInit } from '@angular/core';
import {Parent} from "../../../dto/parent";
import {ParentService} from "../../../service/parent.service";

@Component({
  selector: 'app-psignin',
  templateUrl: './psignin.component.html',
  styleUrls: ['./psignin.component.css']
})
export class PsigninComponent implements OnInit {

  parent:Parent = new Parent();
  failed: boolean;

  inValidLogin:boolean;

  constructor(private parentService: ParentService) { }

  ngOnInit() {
  }
  login(): void{
    this.parentService.login(this.parent).subscribe(
      (result)=>{

        this.failed = !result;
      }
    );
  }

}
