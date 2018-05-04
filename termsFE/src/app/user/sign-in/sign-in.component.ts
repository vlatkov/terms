import { Component, OnInit } from '@angular/core';
import { UserService } from '../../shared/user.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  isLoginError = false;
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
  }

  OnSubmit(username, password) {
     this.userService.userAuthentication(username, password).subscribe((data: any) => {
      localStorage.setItem('userToken', data.token);
      this.router.navigate(['/home']);
    },
    (err: HttpErrorResponse) => {
      this.isLoginError = true;
    });
  }

}
