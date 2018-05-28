import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import {ValidationManager} from 'ng2-validation-manager';
import {UserService} from '../../shared/user.service';
import {HttpErrorResponse} from '@angular/common/http';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {Observable} from 'rxjs/Observable';

@Component({
  selector: 'resetpass',
  templateUrl: './resetpass.component.html',
  styleUrls: ['./resetpass.component.scss']
})
export class ResetpassComponent implements OnInit {

  password;
  repassword;
  username;
  email;
  language = 'en';
  hide = false;
  emailAddress = false;

  constructor(private trans: TranslateService,
              private userService: UserService,
              private route: Router,
              private toast: ToastrService) {
    trans.setDefaultLang('en');
    trans.use('en');

  }

  formReset = new ValidationManager({
    'email'       : 'required|email',
    'password'    : 'required|rangeLength:8,50',
    'repassword'  : 'required|equalTo:password'
  });

  ngOnInit() {
    this.password = null;
    this.repassword = null;
    this.email = null;
  }

  setlanguage(value) {
  this.trans.setDefaultLang(value);
  this.trans.use(value);
  this.language = value;
}

  resetPass() {
    this.userService.resetPassword(this.email, this.password).subscribe((data: any) => {
      this.route.navigate(['/notfound']);
      }
    , (err: HttpErrorResponse ) => {
      console.log(err.message);
      });
  }

  checkEmail() {

    if (!this.formReset.hasError('email')) {
      this.userService.checkEmail(this.email).subscribe((data: any) => {
        this.emailAddress = false;
        this.toast.warning(this.trans.instant('Forgot.exist_email'));
      }, (err: HttpErrorResponse) => {
        this.emailAddress = true;
      });

    }
  }

}
