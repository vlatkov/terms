import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'rxjs/add/operator/map';
import { User } from './user.model';
import { Configuration } from '../configuration/app.constants';

@Injectable()
export class UserService {
  readonly rootUrl = this.cons.Server;
  constructor(private http: HttpClient, private cons: Configuration) { }

  registerUser(user: User) {
    const body: User = {
      UserName: user.UserName,
      Password: user.Password,
      Email: user.Email,
      FirstName: user.FirstName,
      LastName: user.LastName
    };
    const reqHeader = new HttpHeaders({'No-Auth': 'True'});
    return this.http.post(this.rootUrl + '/api/register', body, {headers : reqHeader});
  }

  userAuthentication(username, password) {
    const credentials = {username: username, password: password};
    const reqHeader = new HttpHeaders({ 'Content-Type': 'application/json', 'No-Auth': 'True' });
    return this.http.post(this.rootUrl + 'auth', credentials, { headers: reqHeader });
  }

  getUserClaims() {
   return  this.http.get(this.rootUrl + '/api/GetUserClaims');
  }

}
