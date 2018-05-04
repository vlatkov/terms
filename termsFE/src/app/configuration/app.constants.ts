import {Injectable} from '@angular/core';

@Injectable()
export class Configuration {

  Server = '';
  Api = '';
  ServerWithApiUrl = '';

  constructor() {
  this.Server = 'http://localhost:8899/';
  this.Api = 'api/';
  this.ServerWithApiUrl = this.Server + this.Api;
  }

}
