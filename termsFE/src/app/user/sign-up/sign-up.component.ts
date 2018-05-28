import { Component, OnInit } from '@angular/core';
import { NgForm} from '@angular/forms';
import { User } from '../../shared/user.model';
import { UserService } from '../../shared/user.service';
import {ValidationManager} from 'ng2-validation-manager';
import {ToastrService} from "ngx-toastr";
import {HttpErrorResponse} from "@angular/common/http";
import {TranslateService} from "@ngx-translate/core";


@Component({
  selector: 'sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {
  user: User;
  hide = true;
  password;
  repassword;
  username;
  lastname;
  firstname;
  email;
  role;
  emailAddressExists = false;
  usernameExists = false;
  errorReg = '';

  formRegiser = new ValidationManager({
    'email'       : 'required|email',
    'username'    : 'required|minLength:4|maxLength:15|pattern:[A-Za-z0-9]+([_\.][A-Za-z0-9]+)*',
    'firstname'    : 'required|minLength:2|maxLength:20|alphaSpace',
    'lastname'    : 'required|minLength:2|maxLength:20|alphaSpace',
    'password'    : 'required|rangeLength:8,50',
    'repassword'  : 'required|equalTo:password',
    'role'       : 'required',
  });

  constructor(private userService: UserService,
              private toast: ToastrService,
              private trans: TranslateService) { }

  ngOnInit() {
    this.password = null;
    this.repassword = null;
    this.username = null;
    this.lastname = null;
    this.firstname = null;
    this.email = null;
    this.role = 1;
  }

  resetForm(form?: NgForm) {
    if (form != null) {
      form.reset();
    }
    this.user = {
      username: '',
      repassword: '',
      password: '',
      email: '',
      firstname: '',
      lastname: '',
      role: ''
    };
  }

  OnSubmit(form: NgForm) {
    this.userService.registerUser(form.value)
      .subscribe((data: any) => {
        if (data.Succeeded === true) {
          this.resetForm(form);
          this.toast.success('User registration successful');
        } else {
          this.toast.error(data.Errors[0]); }
      });
  }

  clearForm() {
    this.formRegiser.reset();
    this.user = null;
  }


  checkEmail() {

    if (!this.formRegiser.hasError('email') && this.email.length > 0) {
      this.userService.checkEmail(this.email).subscribe((data: any) => {
        this.emailAddressExists = false;
      }, (err: HttpErrorResponse) => {
        this.emailAddressExists = true;
        this.toast.warning(this.trans.instant('Registration.email_exists'));
        this.errorReg = this.errorReg + '\n' + this.trans.instant('Registration.email_exists');

      });

    }
  }


  checkUsername() {

    if (!this.formRegiser.hasError('username') && this.username.length > 0) {
      this.userService.checkUsername(this.username).subscribe((data: any) => {
        this.usernameExists = false;
      }, (err: HttpErrorResponse) => {
        this.usernameExists = true;
        this.toast.warning(this.trans.instant('Registration.username_exists'));
        this.errorReg = this.errorReg + '\n' + this.trans.instant('Registration.username_exists');
      });

    }
  }
}
