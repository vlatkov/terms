import { Component, OnInit } from '@angular/core';
import { UserService } from '../../shared/user.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import { CustomMaterialModule } from '../../angular.material';
import { CookieService } from 'ngx-cookie';

@Component({
  selector: 'sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit {

  isLoginError = false;
  username;
  password;
  rememberMe = false;
  hide = false;
  constructor(private userService: UserService,
              private router: Router,
              private toast: ToastrService,
              private _cookieService: CookieService ) { }

  ngOnInit() {

    if (this._cookieService.get('remember')) {
      this.username = this._cookieService.get('username');
      this.password = this._cookieService.get('password');

      if (localStorage.getItem('userToken') !== null) {
        this.router.navigate(['/home']);
      }
    }
  }

  OnSubmit() {
     this.userService.userAuthentication(this.username, this.password).subscribe((data: any) => {
      localStorage.setItem('userToken', data.token);
      if (this.rememberMe) {
         this._rememberMe();
       /* console.log(this.rememberMe);
        console.log(JSON.stringify(this.rememberMe));*/
      }

         this.router.navigate(['/home']);
    },
    (err: HttpErrorResponse) => {
      this.isLoginError = true;
      /*console.log(this.rememberMe);
      console.log(JSON.stringify(this.rememberMe));*/
    });
  }

  _resetLoginError() {
    this.isLoginError = false;
  }
  _forgotPass() {
    this.router.navigate(['/resetpass']);
  }
  _rememberMe(): void {
    this._cookieService.put('username', this.username);
    this._cookieService.put('password', this.password);
    this._cookieService.put('remember', JSON.stringify(this.rememberMe));
  }


}
