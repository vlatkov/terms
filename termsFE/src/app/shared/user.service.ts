import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'rxjs/add/operator/map';
import { User } from './user.model';
import { Configuration } from '../configuration/app.constants';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class UserService {
  readonly rootUrl = this.cons.Server;
  constructor(private http: HttpClient, private cons: Configuration) { }

  registerUser(user: User) {
    const body: User = {
      username: user.username,
      firstname: user.firstname,
      lastname: user.lastname,
      password: user.password,
      repassword: user.repassword,
      email: user.email,
      role: user.role
    };
    const reqHeader = new HttpHeaders({'No-Auth': 'True'});
    return this.http.post(this.rootUrl + '/api/register', body, {headers : reqHeader});
  }

  userAuthentication(username, password) {
    const credentials = {username: username, password: password};
    const reqHeader = new HttpHeaders({ 'Content-Type': 'application/json', 'No-Auth': 'True' });
    return this.http.post(this.rootUrl + 'auth', credentials, { headers: reqHeader });
  }
  resetPassword(email, password) {
    const credentials = {email: email, password: password };
    const reqHeader = new HttpHeaders({'Content-Type': 'application/json', 'No-Auth': 'True'});
  return this.http.post(this.rootUrl + this.cons.Api + 'reset', credentials, { headers: reqHeader});
  }

  checkEmail(email): Observable<any> {
    const credentials = {email: email};
    const reqheader = new HttpHeaders({'Content-Type': 'application/json', 'No-Auth': 'True'});
    return this.http.post(this.rootUrl + this.cons.Api + 'check', credentials,  {headers: reqheader});
  }

  checkUsername(username): Observable<any> {
    const credentials = {username: username};
    const reqheader = new HttpHeaders({'Content-Type': 'application/json', 'No-Auth': 'True'});
    return this.http.post(this.rootUrl + this.cons.Api + 'check', credentials,  {headers: reqheader});
  }
}
