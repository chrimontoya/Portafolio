import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { AuthService } from 'src/app/core/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userNameControl: FormControl = new FormControl();
  passwordControl: FormControl = new FormControl();

  constructor(
    private authService: AuthService,
  ) { }

  ngOnInit(): void {
  }

  logIn(){

    const user = {
      username: this.userNameControl.value,
      password: this.passwordControl.value
    };

    this.authService.postLogin(user).subscribe({
      next: (res)=>{
        console.log(res);
      }
    })
  }

}
