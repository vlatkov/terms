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

  ngOnInit() {
  }

  constructor(private trans: TranslateService) {
// this language will be used as a fallback when a translation isn't found in the current language
    trans.setDefaultLang('en');
    // the lang to use, if the lang isn't available, it will use the current loader to get them
    trans.use('en');

  }

  setlanguage() {
  if (this.language === 'en') {
    this.trans.setDefaultLang('sr');
    this.trans.use('sr');
    this.language = 'sr';
  } else {
      this.trans.setDefaultLang('en');
      this.trans.use('en');
    this.language = 'en';
}
}

}
