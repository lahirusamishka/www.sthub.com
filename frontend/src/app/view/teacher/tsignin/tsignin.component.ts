import {Component, OnInit} from '@angular/core';
import {User} from "../../../dto/user";
import {AuthService} from "../../../service/auth.service";
import {MainComponent} from "../../main/main.component";
import {Teacher} from "../../../dto/teacher";

@Component({
  selector: 'app-tsignin',
  templateUrl: './tsignin.component.html',
  styleUrls: ['./tsignin.component.css']
})
export class TsigninComponent implements OnInit {
  user: User = new User();
  failed: boolean;
  validatermassage:string;





  constructor(private authService: AuthService) {
  }

  ngOnInit() {
  }

  login(): void {
    if (!this.user.username==null && !this.user.password==null){


    }else {
      this.authService.login(this.user).subscribe(
        (result) => {
          this.failed = !result;

          sessionStorage.setItem("scode",this.user.username);


          //this.authService.username=this.user.username;
          this.validatermassage=" Invalid User Name or Passwords"
        }
      );
    }






  }

}
