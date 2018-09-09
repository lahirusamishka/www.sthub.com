import { Component, OnInit } from '@angular/core';
import {User} from "../../../dto/user";
import {AuthService} from "../../../service/auth.service";

@Component({
  selector: 'app-tsignin',
  templateUrl: './tsignin.component.html',
  styleUrls: ['./tsignin.component.css']
})
export class TsigninComponent implements OnInit {


  user: User = new User();
  failed: boolean;

  inValidLogin:boolean;

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }
  login(): void{
    this.authService.login(this.user).subscribe(
      (result)=>{
        this.failed = !result;
      }
    );
  }

}
