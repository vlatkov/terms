import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, NgForm, Validators} from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { User } from '../../shared/user.model';
import { UserService } from '../../shared/user.service';
import {ValidationManager} from 'ng2-validation-manager';

@Component({
  selector: 'sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  user: User;
  hide = true;
  password;
  password2;
  username;
  lastname;
  firstname;
  email;

  form = new ValidationManager({
    'email'       : 'required|email',
    'username'    : 'required|minLength:4|maxLength:12|alphaSpace|pattern:[A-Za-z0-9]+([_\.][A-Za-z0-9]+)*',
    'password'    : 'required|rangeLength:8,50',
    'repassword'  : 'required|equalTo:password'
  });

  constructor(private userService: UserService, private toastr: ToastrService) { }

  ngOnInit() {
    this.password = null;
    this.password2 = null;
    this.username = null;
    this.lastname = null;
    this.firstname = null;
    this.email = null;

  }

  resetForm(form?: NgForm) {
    if (form != null) {
      form.reset();
    }
    this.user = {
      UserName: '',
      Password: '',
      Email: '',
      FirstName: '',
      LastName: ''
    };
  }

  OnSubmit(form: NgForm) {
    this.userService.registerUser(form.value)
      .subscribe((data: any) => {
        if (data.Succeeded == true) {
          this.resetForm(form);
          this.toastr.success('User registration successful');
        } else {
          this.toastr.error(data.Errors[0]); }
      });
  }


}
