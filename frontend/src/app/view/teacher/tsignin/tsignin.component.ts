import {Component, OnInit} from '@angular/core';
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
  validatermassage:string;

  constructor(private authService: AuthService) {
  }

  ngOnInit() {
  }

  login(): void {
    if (!this.user.username==null && !this.user.password==null){
  alert("null")

    }else {
      this.authService.login(this.user).subscribe(
        (result) => {
          this.failed = !result;
          this.validatermassage=" Invalid User Name or Passwords"
        }
      );
    }






  }

}
