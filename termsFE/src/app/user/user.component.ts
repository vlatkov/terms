import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {TranslateService} from '@ngx-translate/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class UserComponent implements OnInit {
  hide = false;
  username = '';
  password = '';
  selectedIndex = 0;
  language = 'en';
  forgotpass = false;
  ngOnInit() {
  }
  constructor(private trans: TranslateService) {
    trans.setDefaultLang('en');
    trans.use('en');

  }

  setlanguage(value) {
    this.trans.setDefaultLang(value);
    this.trans.use(value);
    this.language = value;
  }

}
